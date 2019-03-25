package xwpeng.com.tobserver.observer;

import java.util.Observable;

public class DevTechFrontier extends Observable {
    public void postNotify(String content) {
        setChanged();
        notifyObservers(content);
    }
}
