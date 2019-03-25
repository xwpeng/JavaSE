package xwpeng.com.tabstractfactory.theme;

import android.content.Context;

public class LightThemeFactroy extends ThemeFactroy{

    public LightThemeFactroy(Context context) {
        super(context);
    }

    @Override
  public  Button createButton() {
        return new LightButton(context);
    }

    @Override
   public Toolbar createToolbar() {
        return new LightToolbar(context);
    }
}
