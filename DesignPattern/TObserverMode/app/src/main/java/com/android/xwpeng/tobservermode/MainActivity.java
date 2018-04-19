package com.android.xwpeng.tobservermode;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Observable;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private DataCreater dataCreater = new DataCreater();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Observer observer = object -> Log.e(TAG, "onCreate1: " + object.toString());
        dataCreater.registe(observer);
        dataCreater.registe(object -> {
                    Log.e(TAG, "onCreate2: " + object.toString());
                    dataCreater.unRegiste(observer);
                }
        );
        net();
    }

    private void net() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dataCreater.notifyObservers(SystemClock.currentThreadTimeMillis());
            }
        }).start();
    }


}
