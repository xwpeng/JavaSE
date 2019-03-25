package xwpeng.com.tstate.tvcontroller;

public class PowerOffState implements TvState {
    @Override
    public void nextChannel() {
        System.out.println("关机状态不能下一个频道");
    }

    @Override
    public void prevChannel() {
        System.out.println("关机状态不能上一个频道");

    }

    @Override
    public void turnUp() {
        System.out.println("关机状态不能音量+");

    }

    @Override
    public void turnDown() {
        System.out.println("关机状态不能音量-");

    }
}
