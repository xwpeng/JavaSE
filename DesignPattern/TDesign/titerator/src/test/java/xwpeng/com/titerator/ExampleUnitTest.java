package xwpeng.com.titerator;

import org.junit.Test;

import xwpeng.com.titerator.Leader.Boss;
import xwpeng.com.titerator.Leader.Director;
import xwpeng.com.titerator.Leader.GroupLeader;
import xwpeng.com.titerator.Leader.Manager;
import xwpeng.com.titerator.handler.Handler1;
import xwpeng.com.titerator.handler.Handler2;
import xwpeng.com.titerator.handler.Handler3;
import xwpeng.com.titerator.handler.Request1;
import xwpeng.com.titerator.handler.Request2;
import xwpeng.com.titerator.handler.Request3;

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
    public void tHandler() {
        Handler1 handler1 = new Handler1();
        Handler2 handler2 = new Handler2();
        Handler3 handler3 = new Handler3();

        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);

        Request1 request1 = new Request1("request1");
        Request2 request2 = new Request2("request2");
        Request3 request3 = new Request3("request3");

        handler1.handleRequest(request1);
        handler1.handleRequest(request2);
        handler1.handleRequest(request3);
    }

    @Test
    public void tLeader(){
        GroupLeader groupLeader = new GroupLeader();
        Director director = new Director();
        Manager manager = new Manager();
        Boss boss = new Boss();
        groupLeader.setSuperLeader(director);
        director.setSuperLeader(manager);
        manager.setSuperLeader(boss);
        director.handleRequest(90000);
    }
}