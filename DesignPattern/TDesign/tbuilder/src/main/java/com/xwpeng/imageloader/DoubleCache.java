package com.xwpeng.imageloader;

import android.graphics.Bitmap;

public class DoubleCache implements ImageCache {
    ImageCache memroyCache = new MemroyCache();
    ImageCache diskCache = new DiskCache();
    @Override
    public void put(String url, Bitmap bitmap) {
        memroyCache.put(url, bitmap);
        diskCache.put(url, bitmap);
    }

    @Override
    public Bitmap get(String url) {
        Bitmap bitmap = memroyCache.get(url);
        if(bitmap == null) bitmap = diskCache.get(url);
        return bitmap;
    }
}
