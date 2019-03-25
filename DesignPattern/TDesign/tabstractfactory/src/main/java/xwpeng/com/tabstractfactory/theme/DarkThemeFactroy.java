package xwpeng.com.tabstractfactory.theme;

import android.content.Context;

public class DarkThemeFactroy extends ThemeFactroy{

    public DarkThemeFactroy(Context context) {
        super(context);
    }

    @Override
    public Button createButton() {
        return new DarkButton(context);
    }

    @Override
    public Toolbar createToolbar() {
        return new DarkToolbar(context);
    }
}
