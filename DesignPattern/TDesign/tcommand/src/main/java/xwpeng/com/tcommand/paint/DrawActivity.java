package xwpeng.com.tcommand.paint;

import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import xwpeng.com.tcommand.R;

public class DrawActivity extends AppCompatActivity {
    private DrawSurfaceView mDrawSurfaceView;//绘制的View
    private DrawCommand mCommand;//路径绘制命令
    private Paint mPaint;//画笔对象
    private IBrush mBrush;//笔触对象
    private Button redoBtn, undoBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        mPaint = new Paint();
        mPaint.setColor(0xFFFFFFFF);
        mPaint.setStrokeWidth(3);

        mBrush = new NormalBrush();
        mDrawSurfaceView = findViewById(R.id.drawcanvas);
        mDrawSurfaceView.setOnTouchListener(new DrawTouchListener());

//        undoBtn = findViewById(R.id.btn_und0);
//        undoBtn.setEnabled(false);
//        redoBtn = findViewById(R.id.btn_redo);
//        redoBtn.setEnabled(false);

        initListener();
    }

    private void initListener(){
        findViewById(R.id.btn_red).setOnClickListener(v -> {
            mPaint = new Paint();
            mPaint.setStrokeWidth(3);
            mPaint.setColor(0xFFFF0000);
        });
        findViewById(R.id.btn_blue).setOnClickListener(v -> {
            mPaint = new Paint();
            mPaint.setStrokeWidth(3);
            mPaint.setColor(0xFF0000FF);
        });
        findViewById(R.id.btn_green).setOnClickListener(v -> {
            mPaint = new Paint();
            mPaint.setStrokeWidth(3);
            mPaint.setColor(0xFF00FF00);
        });
        findViewById(R.id.btn_nomal_brush).setOnClickListener(v -> mBrush = new NormalBrush());
        findViewById(R.id.btn_circle_brush).setOnClickListener(v -> mBrush = new CircleBrush());

//        undoBtn.setOnClickListener(v -> {
//            if (!mDrawSurfaceView.canUndo()) {
//                undoBtn.setEnabled(false);
//            }
//            redoBtn.setEnabled(true);
//        });
//        redoBtn.setOnClickListener(v -> {
//            if (!mDrawSurfaceView.canRedo()) {
//                redoBtn.setEnabled(false);
//            }
//            undoBtn.setEnabled(true);
//        });

    }

    private class DrawTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                mCommand = new DrawCommand();
                mCommand.paint = mPaint;
                mCommand.path = new Path();
                mBrush.down(mCommand.path, event.getX(), event.getY());
            } else if(event.getAction() == MotionEvent.ACTION_MOVE) {
                mBrush.move(mCommand.path, event.getX(), event.getY());
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                mBrush.up(mCommand.path, event.getX(), event.getY());
                mDrawSurfaceView.add(mCommand);
                mDrawSurfaceView.isDrawing = true;
//                undoBtn.setEnabled(true);
//                redoBtn.setEnabled(false);
            }
            return true;
        }
    }
}
