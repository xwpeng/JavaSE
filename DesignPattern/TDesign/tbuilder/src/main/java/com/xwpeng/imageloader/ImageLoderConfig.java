package com.xwpeng.imageloader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageLoderConfig {
    private ImageLoderConfig() {

    }

    ImageCache imageCache = new MemroyCache();
    ExecutorService mExecutorService =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);

    public static class Builder {
        ImageCache imageCache = new MemroyCache();
        ExecutorService mExecutorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);

        public Builder setImageCache(ImageCache imageCache) {
            this.imageCache = imageCache;
            return this;
        }

        public Builder setExecutorService(ExecutorService executorService) {
            this.mExecutorService = executorService;
            return this;
        }

        public ImageLoderConfig build() {
            ImageLoderConfig imageLoderConfig = new ImageLoderConfig();
            imageLoderConfig.imageCache = this.imageCache;
            imageLoderConfig.mExecutorService = this.mExecutorService;
            return imageLoderConfig;
        }
    }
}
