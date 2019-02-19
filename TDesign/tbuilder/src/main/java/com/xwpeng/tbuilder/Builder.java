package com.xwpeng.tbuilder;

/**
 * Created by xwpeng on 2019/2/19.
 */
public abstract class Builder {
    public abstract void buildBoard(String board);
    public abstract void buildDisplay(String display);
    public abstract void buildOS();
    public abstract Computer create();
}
