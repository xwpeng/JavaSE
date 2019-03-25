package xwpeng.com.tcommand.paint;

import android.graphics.Canvas;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 请求者
 */
public class DrawInvoker {
    //绘制列表
    private List<DrawCommand> drawList = Collections.synchronizedList(new CopyOnWriteArrayList<>());
    //重做列表
    private List<DrawCommand> redoList = Collections.synchronizedList(new CopyOnWriteArrayList<>());

    /**
     * 增加命令
     */
    public void add(DrawCommand command){
        redoList.clear();
        drawList.add(command);
    }

    /**
     * 撤销上一步命令
     */
    public void undo(){
        if (drawList.size() > 0) {
            DrawCommand command = drawList.get(drawList.size() - 1);
            drawList.remove(drawList.size() - 1);
            command.undo();
            redoList.add(command);
        }
    }

    /**
     * 重做上一步撤销的命令
     */
    public  void redo(){
        if (redoList.size() > 0) {
            DrawCommand redoCommand = redoList.get(redoList.size() - 1);
            redoList.remove(redoList.size() - 1);
            drawList.add(redoCommand);
        }
    }

    /**
     * 执行命令
     */
    public void execute(Canvas canvas) {
        if (drawList != null) for (DrawCommand command : drawList) command.draw(canvas);
    }

    /**
     * 是否可以重做
     */
    public boolean canRedo(){
        return redoList.size() > 0;
    }

    /**
     * 是否可以撤销
     */
    public boolean canUndo(){
        return drawList.size() > 0;
    }
}
