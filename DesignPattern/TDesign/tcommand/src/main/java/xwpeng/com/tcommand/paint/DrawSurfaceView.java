package xwpeng.com.tcommand.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

/**
 * 接收者
 */

public class DrawSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    public boolean isDrawing, isRuning;//是否可以绘制、绘制线程是否可以运行
    private Bitmap mBitmap;//绘制到的位图对象
    private DrawInvoker mInvoker;//绘制命令请求对象
    private DrawThread mThread;//绘制线程


    public DrawSurfaceView(Context context) {
       this(context, null);
    }

    public DrawSurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);


    }

    public DrawSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs,defStyleAttr,0);
    }

    public DrawSurfaceView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mInvoker = new DrawInvoker();
        mThread = new DrawThread();
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isRuning = true;
        mThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    boolean retry = true;
    isRuning = false;
    while (retry) {
        try {
            mThread.join();
            retry = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }

    public void add(DrawCommand path) {
        mInvoker.add(path);
    }

    public void redo() {
        isDrawing = true;
        mInvoker.redo();
    }

    public void undo() {
        isDrawing = true;
        mInvoker.undo();
    }

    public boolean canUndo() {
        return mInvoker.canUndo();
    }

    public boolean canRedo() {
        return mInvoker.canRedo();
    }

    private class DrawThread extends Thread {
        @Override
        public void run() {
            super.run();
            Canvas canvas = null;
            while (isRuning) {
                try {
                    canvas = getHolder().lockCanvas(null);
                    if (canvas == null) return;
                    if (mBitmap == null)
                        mBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                    Canvas c = new Canvas(mBitmap);
                    c.drawColor(0, PorterDuff.Mode.CLEAR);
                    canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    mInvoker.execute(c);
                    canvas.drawBitmap(mBitmap, 0, 0, null);
                } finally {
                    try {
                        getHolder().unlockCanvasAndPost(canvas);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}
