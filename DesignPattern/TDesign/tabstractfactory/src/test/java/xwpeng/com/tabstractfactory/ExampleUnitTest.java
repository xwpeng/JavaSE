package xwpeng.com.tabstractfactory;

import org.junit.Test;

import xwpeng.com.tabstractfactory.car.ICarPartFactory;
import xwpeng.com.tabstractfactory.car.Q3PartFactroy;
import xwpeng.com.tabstractfactory.car.Q7PartFactroy;
import xwpeng.com.tabstractfactory.theme.LightThemeFactroy;
import xwpeng.com.tabstractfactory.theme.ThemeFactroy;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void partCreate(){
        ICarPartFactory factroy = new Q3PartFactroy();
        factroy.createTire().getCode();
        factroy.createEngine().run();
        factroy.createBrake().brake();

        factroy = new Q7PartFactroy();
        factroy.createTire().getCode();
        factroy.createEngine().run();
        factroy.createBrake().brake();
    }


}