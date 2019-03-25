package xwpeng.com.tstate.tvcontroller;

public class PowerOnState implements TvState {
    @Override
    public void nextChannel() {
        System.out.println("下一个频道");
    }

    @Override
    public void prevChannel() {
        System.out.println("上一个频道");

    }

    @Override
    public void turnUp() {
        System.out.println("音量+");

    }

    @Override
    public void turnDown() {
        System.out.println("音量-");

    }
}
