package xwpeng.com.tabstractfactory.theme;

import android.content.Context;

public abstract class ThemeFactroy {
    protected Context context;

    protected ThemeFactroy(Context context) {
        this.context = context;
    }

   public abstract Button createButton();

    public abstract Toolbar createToolbar();
}
