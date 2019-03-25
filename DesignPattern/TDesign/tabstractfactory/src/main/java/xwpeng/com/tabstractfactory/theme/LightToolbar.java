package xwpeng.com.tabstractfactory.theme;

import android.content.Context;

public class LightToolbar extends Toolbar {
    public LightToolbar(Context context) {
        super(context);
    }

    @Override
    public void initIcon() {
        System.out.println("亮色的toolbar图标");
    }

    @Override
    public  void initTitle() {
        System.out.println("亮色的toolbar标题");
    }
}
