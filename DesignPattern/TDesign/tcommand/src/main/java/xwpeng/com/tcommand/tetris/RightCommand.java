package xwpeng.com.tcommand.tetris;

public class RightCommand implements Command {
    private TetrisMachine tetrisMachine;
    @Override
    public void execute() {
        tetrisMachine.toRight();
    }

    public RightCommand(TetrisMachine t) {
        this.tetrisMachine = t;
    }
}
