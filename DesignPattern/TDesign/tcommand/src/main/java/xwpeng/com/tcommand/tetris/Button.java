package xwpeng.com.tcommand.tetris;

/**
 * 请求者
 */
public class Button {
    private LeftCommand leftCommand;
    private RightCommand rightCommand;
    private FallCommand fallCommand;
    private TransformCommand transformCommand;

    public void setLeftCommand(LeftCommand leftCommand) {
        this.leftCommand = leftCommand;
    }

    public void setRightCommand(RightCommand rightCommand) {
        this.rightCommand = rightCommand;
    }

    public void setFallCommand(FallCommand fallCommand) {
        this.fallCommand = fallCommand;
    }

    public void setTransformCommand(TransformCommand transformCommand) {
        this.transformCommand = transformCommand;
    }

    public void toLeft(){
        if (leftCommand != null) leftCommand.execute();
    }

    public void toRight(){
        if (rightCommand != null) rightCommand.execute();
    }

    public void fall(){
        if (fallCommand != null) fallCommand.execute();
    }

    public void transForm(){
        if (transformCommand != null) transformCommand.execute();
    }
}
