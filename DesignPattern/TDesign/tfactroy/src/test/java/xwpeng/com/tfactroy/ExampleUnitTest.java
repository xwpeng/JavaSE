package xwpeng.com.tfactroy;

import org.junit.Test;

import xwpeng.com.tfactroy.car.AudiCarFactroy;
import xwpeng.com.tfactroy.car.AudiQ3;
import xwpeng.com.tfactroy.car.AudiQ5;
import xwpeng.com.tfactroy.car.AudiQ7;

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
    public void tFactory(){
        ConcreteFactroy concreteFactroy = new ConcreteFactroy();
        concreteFactroy.createProduct().method();
    }

    @Test
    public void tAFactory(){
        AConcreteFactroy concreteFactroy = new AConcreteFactroy();
        concreteFactroy.createProduct(ConcreteProductB.class).method();
    }

    @Test
    public void tBFactory(){
       BFactory.createProductB().method();
    }

    @Test
    public void tAudi(){
        AudiCarFactroy audiCarFactroy = new AudiCarFactroy();
        AudiQ3 audiQ3 = audiCarFactroy.createAudicar(AudiQ3.class);
        audiQ3.drive();
        audiQ3.selfNavigation();
        AudiQ5 audiQ5 = audiCarFactroy.createAudicar(AudiQ5.class);
        audiQ5.drive();
        audiQ5.selfNavigation();
        AudiQ7 audiQ7 = audiCarFactroy.createAudicar(AudiQ7.class);
        audiQ7.drive();
        audiQ7.selfNavigation();
    }
}