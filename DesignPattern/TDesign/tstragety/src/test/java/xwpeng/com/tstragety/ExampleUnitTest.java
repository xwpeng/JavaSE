package xwpeng.com.tstragety;

import org.junit.Test;

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
    public  void tStragety(){
//        CalculateStragety stragety = new BusStragety();
        CalculateStragety stragety = new SubwayStrategy();
        int price = stragety.calculatePrice(16);
        System.out.println(String.valueOf(price));
    }
}