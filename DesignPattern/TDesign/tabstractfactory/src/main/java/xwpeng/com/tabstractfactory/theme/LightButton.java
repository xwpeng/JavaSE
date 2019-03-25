package xwpeng.com.tabstractfactory.theme;

import android.content.Context;

public class LightButton extends Button {

    public LightButton(Context context) {
        super(context);
    }

    @Override
    public void initTextColor() {
        System.out.println("亮色的按钮文本");
    }

    @Override
    public void initBackGround() {
        System.out.println("亮色的按钮背景");
    }
}
