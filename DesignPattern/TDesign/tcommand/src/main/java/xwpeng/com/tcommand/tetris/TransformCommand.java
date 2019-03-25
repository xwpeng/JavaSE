package xwpeng.com.tcommand.tetris;

public class TransformCommand implements Command {
    private TetrisMachine tetrisMachine;
    @Override
    public void execute() {
        tetrisMachine.transform();
    }

    public TransformCommand(TetrisMachine t) {
        this.tetrisMachine = t;
    }
}
