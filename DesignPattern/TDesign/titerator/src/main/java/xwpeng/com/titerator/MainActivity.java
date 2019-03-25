package xwpeng.com.titerator;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import xwpeng.com.titerator.recevier.FirstReceiver;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_send_broadcast).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction("xwpeng.com.titerator.order");
                i.putExtra("msg", "msg from mainActiity");
                i.putExtra("limit", 10);
                //突破8.0广播限制
                i.addFlags(0x01000000);
                sendOrderedBroadcast(i, null);
            }
        });
    }
}
