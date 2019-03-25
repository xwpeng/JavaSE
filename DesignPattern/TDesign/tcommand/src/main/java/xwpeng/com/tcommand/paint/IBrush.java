package xwpeng.com.tcommand.paint;


import android.graphics.Path;

public interface IBrush {
    void down(Path path, float x, float y);
    void move(Path path, float x, float y);
    void up(Path path, float x, float y);
}
