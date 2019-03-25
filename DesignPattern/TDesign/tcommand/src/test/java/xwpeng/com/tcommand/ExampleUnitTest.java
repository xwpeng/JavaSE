package xwpeng.com.tcommand;

import org.junit.Test;

import xwpeng.com.tcommand.tetris.Button;
import xwpeng.com.tcommand.tetris.FallCommand;
import xwpeng.com.tcommand.tetris.LeftCommand;
import xwpeng.com.tcommand.tetris.RightCommand;
import xwpeng.com.tcommand.tetris.TetrisMachine;
import xwpeng.com.tcommand.tetris.TransformCommand;

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
    public void playTetris(){
        Button button = new Button();
        TetrisMachine machine = new TetrisMachine();
        button.setLeftCommand(new LeftCommand(machine));
        button.setRightCommand(new RightCommand(machine));
        button.setFallCommand(new FallCommand(machine));
        button.setTransformCommand(new TransformCommand(machine));
        button.transForm();
        button.toRight();
        button.fall();
        button.toLeft();
        button.fall();
    }
}