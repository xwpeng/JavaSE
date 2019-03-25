package xwpeng.com.tobserver.observer;

import java.util.Observable;
import java.util.Observer;

public class Coder implements Observer {
    private String name;

    public Coder(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name + " :收到订阅: " + arg);
    }
}
