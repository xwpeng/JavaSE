package com.xwpeng.imageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;


public class ImageLoader {
    private ImageLoderConfig mConfig;
    Handler mUIHandler = new Handler(Looper.getMainLooper());

    private ImageLoader() {

    }

    public static ImageLoader getInstance() {
        return ImageLoaderHolder.inStance;
    }

    public void init(ImageLoderConfig config) {
        this.mConfig = config;
    }

    public static class ImageLoaderHolder {
        private static ImageLoader inStance = new ImageLoader();
    }

    private void updateImageView(final ImageView imageView, final Bitmap bitmap) {
        mUIHandler.post(new Runnable() {
            @Override
            public void run() {
                imageView.setImageBitmap(bitmap);
            }
        });
    }

    public void displayImageView(final String url, final ImageView imageView) {
        Bitmap bitmap = mConfig.imageCache.get(url);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }
        imageView.setTag(url);
        mConfig.mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bm = downloadImage(url);
                if (bm == null) return;
                if (imageView.getTag().equals(url)) {
                    updateImageView(imageView, bm);
                }
                mConfig.imageCache.put(url, bm);
            }
        });
    }

    private Bitmap downloadImage(String imageUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imageUrl);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
