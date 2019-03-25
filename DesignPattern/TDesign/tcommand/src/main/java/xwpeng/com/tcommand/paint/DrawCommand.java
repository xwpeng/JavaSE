package xwpeng.com.tcommand.paint;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * 命令者
 */
public class DrawCommand implements IDrawCommand {
    public Path path;
    public Paint paint;
    @Override
    public void draw(Canvas canvas) {
        canvas.drawPath(path, paint);
    }

    @Override
    public void undo() {

    }
}
