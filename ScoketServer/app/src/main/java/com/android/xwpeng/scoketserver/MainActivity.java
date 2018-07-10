package com.android.xwpeng.scoketserver;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private EditText mEditText;
    private Socket mSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.init_btn).setOnClickListener(v -> {
            new Thread(this::initServer).start();
        });
        findViewById(R.id.send_btn).setOnClickListener(v -> {
            new Thread(this::sendMsg).start();
        });
        mEditText = findViewById(R.id.msg_edittext);
    }
    
    private void sendMsg() {
        if (mSocket == null) return;
        String msg = mEditText.getText().toString();
        if (TextUtils.isEmpty(msg)) return;
        sendMsg(msg.getBytes());
    }

    private void sendMsg(byte[] bytes) {
        try {
            if (mSocket == null) return;
            OutputStream out = mSocket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(out);
            dataOutputStream.writeInt(bytes.length);
            dataOutputStream.write(bytes);
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(1980);
            mSocket = serverSocket.accept();
            handleClient(mSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleClient(Socket socket) throws IOException {
        //接收客户端传递的数据流
        InputStream inputStream = socket.getInputStream();
        DataInputStream in = new DataInputStream(inputStream);
        byte[] buffer = new byte[1024];
        while (true) {
            int n ;
            n = in.readInt();
            if (n == 0) {
                sendMsg(new byte[0]);
                continue;
            }
           int i = in.read(buffer);
            Log.e(TAG, "socketServer accpte: " + new String(buffer, 0, i));
        }
    }
}
