package com.android.xwpeng.scoketserver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    public static final String TAG = MainActivity2.class.getSimpleName();
    private EditText mEditText;
    private MultiServer mMultiServer;

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


    private void initServer() {
        mMultiServer = new MultiServer();
        mMultiServer.start();
    }

    private void sendMsg() {
        String msg = mEditText.getText().toString();
        if (TextUtils.isEmpty(msg)) return;
        if (mMultiServer == null) return;
        List<Socket> clients = mMultiServer.clients;
        for (Socket client : clients) {
            MultiServer.sendMsg(client, msg.getBytes());
        }
    }
}
