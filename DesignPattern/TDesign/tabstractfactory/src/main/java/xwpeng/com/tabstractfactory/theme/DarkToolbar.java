package xwpeng.com.tabstractfactory.theme;

import android.content.Context;

public class DarkToolbar extends Toolbar {
    public DarkToolbar(Context context) {
        super(context);
    }

    @Override
   public void initIcon() {
        System.out.println("暗色的toolbar图标");
    }

    @Override
   public void initTitle() {
        System.out.println("暗色的toolbar标题");
    }
}
