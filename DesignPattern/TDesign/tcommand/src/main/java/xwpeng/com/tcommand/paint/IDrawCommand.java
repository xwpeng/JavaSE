package xwpeng.com.tcommand.paint;

import android.graphics.Canvas;

public interface IDrawCommand {
    /**
     * 绘制命令
     * @param canvas
     */
    void draw(Canvas canvas);
    void undo();
}
