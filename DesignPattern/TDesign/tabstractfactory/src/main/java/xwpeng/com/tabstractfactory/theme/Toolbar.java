package xwpeng.com.tabstractfactory.theme;

import android.content.Context;

public abstract class Toolbar {
    private  Context context;
    public abstract void initIcon();

    public abstract void initTitle();

    public Toolbar(Context context) {
        this.context = context;
    }
}
