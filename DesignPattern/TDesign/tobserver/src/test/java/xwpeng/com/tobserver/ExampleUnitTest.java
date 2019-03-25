package xwpeng.com.tobserver;

import org.junit.Test;

import xwpeng.com.tobserver.observer.Coder;
import xwpeng.com.tobserver.observer.DevTechFrontier;

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
    public void tObserver() {
        Coder coder1 = new Coder("code1");
        Coder coder2 = new Coder("code2");
        Coder coder3 = new Coder("code3");

        DevTechFrontier devTechFrontier = new DevTechFrontier();
        devTechFrontier.addObserver(coder1);
        devTechFrontier.addObserver(coder2);
        devTechFrontier.addObserver(coder3);
        devTechFrontier.postNotify("即将下班");
    }
}