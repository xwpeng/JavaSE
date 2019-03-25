package com.xwpeng.tbuilder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.xwpeng.imageloader.DoubleCache;
import com.xwpeng.imageloader.ImageLoader;
import com.xwpeng.imageloader.ImageLoderConfig;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.iv_show);
        ImageLoderConfig config = new ImageLoderConfig
                .Builder()
                .setImageCache(new DoubleCache())
                .build();
        ImageLoader.getInstance().init(config);
        String url = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1550654483&di=8da6f5bc77f0e30a1a8d0bbbf8eca494&src=http://image.xcar.com.cn/attachments/a/day_140319/2014031916_1bd6ffb9d5553620f870beYW9d0Nxj0n.jpg";
        ImageLoader.getInstance().displayImageView(url,imageView);
    }

    public static void main(String[] args) {
        Builder builder = new MacbookBuilder();
        Director pcDirector = new Director(builder);
        pcDirector.construct("因特尔主板", "retina 显示器");
        System.out.println("computer Info : " + builder.create());
    }
}
