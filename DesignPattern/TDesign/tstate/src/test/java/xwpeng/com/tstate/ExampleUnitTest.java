package xwpeng.com.tstate;

import org.junit.Test;

import xwpeng.com.tstate.tvcontroller.TvController;

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
    public void tv(){
        TvController tvController = new TvController();
        tvController.nextChannel();
        tvController.prevChannel();
        tvController.turnUp();
        tvController.turnDown();

        tvController.powerOn();
        tvController.nextChannel();
        tvController.prevChannel();
        tvController.turnUp();
        tvController.turnDown();
    }
}