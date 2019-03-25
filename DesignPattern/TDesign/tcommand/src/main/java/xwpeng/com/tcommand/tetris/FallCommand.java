package xwpeng.com.tcommand.tetris;

public class FallCommand implements Command {
    private TetrisMachine tetrisMachine;
    @Override
    public void execute() {
        tetrisMachine.fastToBottom();
    }

    public FallCommand(TetrisMachine t) {
        this.tetrisMachine = t;
    }
}
