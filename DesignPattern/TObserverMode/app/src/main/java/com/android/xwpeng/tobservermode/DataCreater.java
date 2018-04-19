package com.android.xwpeng.tobservermode;

import java.util.Vector;

/**
 * 被观察者，数据生产者
 * Created by xwpeng on 2018/4/17.
 */

public class DataCreater implements Subject {
    private Vector<Observer> observerVetor = new Vector();
    @Override
    public void registe(Observer observer) {
         observerVetor.add(observer);
    }

    @Override
    public void unRegiste(Observer observer) {
     observerVetor.remove(observer);
    }

    @Override
    public void notify(Object message) {
    for (Observer observer: observerVetor) {
        observer.update(message);
    }
    }
}
