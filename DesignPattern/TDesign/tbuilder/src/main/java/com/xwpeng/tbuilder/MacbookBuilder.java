package com.xwpeng.tbuilder;

/**
 * Created by xwpeng on 2019/2/19.
 */
public class MacbookBuilder extends Builder {
    private Computer computer = new Macbook();

    @Override
    public void buildBoard(String board) {
        computer.mBoard = board;
    }

    @Override
    public void buildDisplay(String display) {
        computer.mDisplay = display;
    }

    @Override
    public void buildOS() {
        computer.setmOS();
    }

    @Override
    public Computer create() {
        return computer;
    }
}
