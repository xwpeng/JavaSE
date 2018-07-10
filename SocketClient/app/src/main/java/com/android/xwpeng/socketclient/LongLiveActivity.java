package com.android.xwpeng.socketclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class LongLiveActivity extends AppCompatActivity {
    public static final String TAG = LongLiveActivity.class.getSimpleName();
    private EditText mEditText,mEditText2;
    private LongLiveSocket mLongLiveSocket;
    private LongLiveSocket mLongLiveSocket2;

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

        findViewById(R.id.connect_btn2).setOnClickListener(v -> {
            new Thread(this::initClient2).start();
        });
        findViewById(R.id.send_btn2).setOnClickListener(v -> {
            new Thread(this::sendMsg2).start();
        });
        mEditText2 = findViewById(R.id.msg_edittext2);
    }

    private void sendMsg() {
        String msg = mEditText.getText().toString();
        if (TextUtils.isEmpty(msg)) return;
        if (mLongLiveSocket != null)
            mLongLiveSocket.write(msg.getBytes(), new LongLiveSocket.WritingCallback() {
                @Override
                public void onSuccess() {
                Log.e(TAG, "write sucess");
                }

                @Override
                public void onFail(byte[] data, int offset, int len) {

                }
            });

    }

    private void initClient() {
        mLongLiveSocket = new LongLiveSocket("localhost", 1980
                , (data, offset, len) -> Log.e(TAG, "client accpte: " + new String(data, offset, len))
                , () -> true);
    }

    private void sendMsg2() {
        String msg = mEditText2.getText().toString();
        if (TextUtils.isEmpty(msg)) return;
        if (mLongLiveSocket2 != null)
            mLongLiveSocket2.write(msg.getBytes(), new LongLiveSocket.WritingCallback() {
                @Override
                public void onSuccess() {
                    Log.e(TAG, "write2 sucess");
                }

                @Override
                public void onFail(byte[] data, int offset, int len) {

                }
            });
    }

    private void initClient2() {
        mLongLiveSocket2 = new LongLiveSocket("localhost", 1980
                , (data, offset, len) -> Log.e(TAG, "client2 accpte: " + new String(data, offset, len))
                , () -> true);
    }

}
