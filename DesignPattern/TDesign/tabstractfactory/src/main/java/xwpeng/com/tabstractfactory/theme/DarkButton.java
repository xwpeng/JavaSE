package xwpeng.com.tabstractfactory.theme;

import android.content.Context;

public class DarkButton extends Button {

    public DarkButton(Context context) {
        super(context);
    }

    @Override
    public void initTextColor() {
        System.out.println("暗色的按钮文本");
    }

    @Override
    public void initBackGround() {
        System.out.println("暗色的按钮背景");
    }
}
