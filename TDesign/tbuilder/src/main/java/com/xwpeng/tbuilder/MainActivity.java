package com.xwpeng.tbuilder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void main(String[] args) {
        Builder builder = new MacbookBuilder();
        Director pcDirector = new Director(builder);
        pcDirector.construct("因特尔主板", "retina 显示器");
        System.out.println("computer Info : " + builder.create());
    }
}
