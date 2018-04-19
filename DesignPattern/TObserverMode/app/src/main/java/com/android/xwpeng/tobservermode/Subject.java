package com.android.xwpeng.tobservermode;

/**
 * 抽象主题，抽象被观察者
 * Created by xwpeng on 2018/4/17.
 */

public interface Subject {
    void registe(Observer observer);
    void unRegiste(Observer observer);
    void notify(Object message);
}
