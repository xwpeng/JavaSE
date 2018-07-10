package com.android.xwpeng.socketclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientActivity extends AppCompatActivity {
    public static final String TAG = ClientActivity.class.getSimpleName();
    private Socket mSocket;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.connect_btn).setOnClickListener(v -> {
            new Thread(this::initClient).start();
        });
        findViewById(R.id.send_btn).setOnClickListener(v -> {
            new Thread(this::sendMsg).start();
        });
        mEditText = findViewById(R.id.msg_edittext);
    }

    private void sendMsg() {
        try {
            if (mSocket == null) return;
            String msg = mEditText.getText().toString();
            if (TextUtils.isEmpty(msg)) return;
            OutputStream out = mSocket.getOutputStream();
            out.write(msg.getBytes());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initClient() {
        try {
            mSocket = new Socket("localhost",1980);
            accpteMsg(mSocket);
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }

    private void accpteMsg(Socket socket) throws IOException {
        InputStream in = socket.getInputStream();
        byte[] buffer = new byte[1024];
        while (true) {
            int n;
            if ((n = in.read(buffer)) > 0)
                Log.e(TAG, "client accpte: " + new String(buffer, 0, n));
        }
    }
}
