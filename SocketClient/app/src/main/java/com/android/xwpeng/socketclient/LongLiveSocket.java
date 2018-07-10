package com.android.xwpeng.socketclient;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 长连接的
 * Created by xwpeng on 2018/7/9.
 */

public class LongLiveSocket {
    private static final String TAG = "LongLiveSocket";
    private static final long HEART_BEAT_INTERVAL_MILLIS = 5 * 1000;
    private static final long HEART_BEAT_TIMEOUT_MILLIS = 20 * 1000;

    public interface ErrorCallback {
        boolean onError();
    }

    public interface ReadDataCallback {
        void onRead(byte[] data, int offset, int len);
    }


    /**
     * 写数据回调
     */
    public interface WritingCallback {
        void onSuccess();

        void onFail(byte[] data, int offset, int len);
    }


    private final String mHost;
    private final int mPort;
    private final ReadDataCallback mDataCallback;
    private final ErrorCallback mErrorCallback;

    private final HandlerThread mWriterThread;
    private final Handler mWriterHandler;
    private final Handler mUIHandler = new Handler(Looper.getMainLooper());

    private final Object mLock = new Object();
    private Socket mSocket;  // guarded by mLock
    private boolean mClosed; // guarded by mLock

    private final Runnable mHeartBeatTask = new Runnable() {
        @Override
        public void run() {
            write(new byte[0], new WritingCallback() {
                @Override
                public void onSuccess() {
                    // 递归不断write
                    mWriterHandler.postDelayed(mHeartBeatTask, HEART_BEAT_INTERVAL_MILLIS);
                    //超时处理
                    mUIHandler.postDelayed(mHeartBeatTimeoutTask, HEART_BEAT_TIMEOUT_MILLIS);
                }

                @Override
                public void onFail(byte[] data, int offset, int len) {
                    // write() 方法会处理失败
                }
            });
        }
    };

    private final Runnable mHeartBeatTimeoutTask = () -> {
        Log.e(TAG, "mHeartBeatTimeoutTask#run: heart beat timeout");
        closeSocket();
    };


    public LongLiveSocket(String host, int port, ReadDataCallback dataCallback, ErrorCallback errorCallback) {
        mHost = host;
        mPort = port;
        mDataCallback = dataCallback;
        mErrorCallback = errorCallback;

        mWriterThread = new HandlerThread("socket-writer");
        mWriterThread.start();
        mWriterHandler = new Handler(mWriterThread.getLooper());
        mWriterHandler.post(this::initSocket);
    }

    private void initSocket() {
        if (closed()) return;
        try {
            Socket socket = new Socket(mHost, mPort);
            synchronized (mLock) {
                if (mClosed) {
                    silentlyClose(socket);
                    return;
                }
                mSocket = socket;
                new Thread(new ReaderTask(socket), "socket-reader").start();
                //发送心跳数据
                mWriterHandler.post(mHeartBeatTask);
            }
        } catch (IOException e) {
            Log.e(TAG, "initSocket: ", e);
        }
    }

    public void write(byte[] data, WritingCallback callback) {
        write(data, 0, data.length, callback);
    }

    public void write(byte[] data, int offset, int len, WritingCallback callback) {
        mWriterHandler.post(() -> {
            Socket socket = getSocket();
            if (socket == null) {
                // initSocket 失败而客户说不需要重连，但客户又叫我们给他发送数据
                throw new IllegalStateException("Socket not initialized");
            }
            try {
                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream out = new DataOutputStream(outputStream);
                out.writeInt(len);
                outputStream.write(data, offset, len);
                callback.onSuccess();
            } catch (IOException e) {
                Log.e(TAG, "write: ", e);
                closeSocket();
                callback.onFail(data, offset, len);
                if (!closed() && mErrorCallback.onError()) {
                    initSocket();
                }
            }
        });
    }

    private boolean closed() {
        synchronized (mLock) {
            return mClosed;
        }
    }

    private Socket getSocket() {
        synchronized (mLock) {
            return mSocket;
        }
    }

    private void closeSocket() {
        synchronized (mLock) {
            closeSocketLocked();
        }
    }

    private void closeSocketLocked() {
        if (mSocket == null) return;
        silentlyClose(mSocket);
        mSocket = null;
        mWriterHandler.removeCallbacks(mHeartBeatTask);
    }

    public void close() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            new Thread() {
                @Override
                public void run() {
                    doClose();
                }
            }.start();
        } else {
            doClose();
        }
    }

    private void doClose() {
        synchronized (mLock) {
            mClosed = true;
            // 关闭 socket，从而使得阻塞在 socket 上的线程返回
            closeSocketLocked();
        }
        mWriterThread.quit();
        // 在重连的时候，有个 sleep
        mWriterThread.interrupt();
    }


    private static void silentlyClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                Log.e(TAG, "silentlyClose: ", e);
            }
        }
    }


    private class ReaderTask implements Runnable {

        private final Socket mSocket;

        public ReaderTask(Socket socket) {
            mSocket = socket;
        }

        @Override
        public void run() {
            try {
                readResponse();
            } catch (IOException e) {
                Log.e(TAG, "ReaderTask#run: ", e);
            }
        }

        private void readResponse() throws IOException {
            byte[] buffer = new byte[1024];
            InputStream inputStream = mSocket.getInputStream();
            DataInputStream in = new DataInputStream(inputStream);
            int n;
            while (true) {
                n = in.readInt();
                if (n == 0) {
                    Log.e(TAG, "readResponse: heart beat received");
                    mUIHandler.removeCallbacks(mHeartBeatTimeoutTask);
                    continue;
                }
                int i = in.read(buffer);
                mDataCallback.onRead(buffer, 0, i);
            }
        }

        private int readn(InputStream in, byte[] buffer, int n) throws IOException {
            int offset = 0;
            while (n > 0) {
                int readBytes = in.read(buffer, offset, n);
                if (readBytes < 0) break;
                n -= readBytes;
                offset += readBytes;
            }
            return n;
        }
    }

}
