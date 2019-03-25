package xwpeng.com.tabstractfactory.theme;

import android.content.Context;

public abstract class Button {
    private  Context context;
   public abstract void initTextColor();

    public abstract void initBackGround();

    public Button(Context context) {
        this.context = context;
    }
}
