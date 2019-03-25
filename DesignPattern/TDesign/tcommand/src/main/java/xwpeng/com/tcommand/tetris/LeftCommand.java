package xwpeng.com.tcommand.tetris;

public class LeftCommand implements Command {
    private TetrisMachine tetrisMachine;
    @Override
    public void execute() {
        tetrisMachine.toLeft();
    }

    public LeftCommand(TetrisMachine t) {
        this.tetrisMachine = t;
    }
}
