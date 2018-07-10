package com.android.xwpeng.scoketserver;

import android.util.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xwpeng on 2018/7/10.
 */

public class MultiServer extends Thread {
    public static final String TAG = MultiServer.class.getSimpleName();
    private ServerSocket serverSocket;
    public List<Socket> clients = new ArrayList();

    public MultiServer() {
        try {
            serverSocket = new ServerSocket(1980);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            System.out.println("Listenning...");
            try {
                Socket socket = serverSocket.accept();
                clients.add(socket);
                ServerThread th = new ServerThread(socket);
                th.start();
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private static class ServerThread extends Thread {

        Socket socket = null;

        public ServerThread(Socket sk) {
            this.socket = sk;
        }

        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                DataInputStream in = new DataInputStream(inputStream);
                byte[] buffer = new byte[1024];
                while (true) {
                    int n ;
                    n = in.readInt();
                    if (n == 0) {
                        sendMsg(socket, new byte[0]);
                        continue;
                    }
                    int i = in.read(buffer);
                    Log.e(TAG, "socketServer accpte: " + new String(buffer, 0, i));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void sendMsg(Socket socket, byte[] bytes) {
        try {
            if (socket == null) return;
            OutputStream out = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(out);
            dataOutputStream.writeInt(bytes.length);
            dataOutputStream.write(bytes);
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
