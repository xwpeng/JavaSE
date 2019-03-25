package xwpeng.com.tabstractfactory;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.Fragment;
import android.view.View;

import org.junit.Test;
import org.junit.runner.RunWith;

import xwpeng.com.tabstractfactory.theme.DarkThemeFactroy;
import xwpeng.com.tabstractfactory.theme.LightThemeFactroy;
import xwpeng.com.tabstractfactory.theme.ThemeFactroy;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("xwpeng.com.tabstractfactory", appContext.getPackageName());
    }

    @Test
    public void themeCreate(){
        Context appContext = InstrumentationRegistry.getTargetContext();
        ThemeFactroy factroy = new LightThemeFactroy(appContext);
        factroy.createButton().initTextColor();
        factroy.createToolbar().initIcon();
        factroy = new DarkThemeFactroy(appContext);
        factroy.createButton().initTextColor();
        factroy.createToolbar().initIcon();
    }

    @Test
    public void view(){
        Context appContext = InstrumentationRegistry.getTargetContext();
        View view = new View(appContext);
        Fragment fragment = new Fragment();

    }
}
