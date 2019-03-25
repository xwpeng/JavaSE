package com.xwpeng.tbuilder;

import android.os.Build;

/**
 * Created by xwpeng on 2019/2/19.
 */
public class Director {
    Builder mBuilder = null;

    public Director(Builder builder) {
        mBuilder = builder;
    }
    /**
     * 构建对象
     */
    public void construct(String board, String display) {
        mBuilder.buildBoard(board);
        mBuilder.buildDisplay(display);
        mBuilder.buildOS();
    }
}
