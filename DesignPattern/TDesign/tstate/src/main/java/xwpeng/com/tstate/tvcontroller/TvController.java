package xwpeng.com.tstate.tvcontroller;

public class TvController implements ITvController {
    private TvState tvState = new PowerOffState();

    private void setState(TvState tvState) {
        this.tvState = tvState;
    }

    @Override
    public void powerOn() {
        setState(new PowerOnState());
    }

    @Override
    public void powerOff() {
        setState(new PowerOffState());
    }

    @Override
    public void nextChannel() {
        tvState.nextChannel();
    }

    @Override
    public void prevChannel() {
        tvState.prevChannel();
    }

    @Override
    public void turnUp() {
        tvState.turnUp();
    }

    @Override
    public void turnDown() {
        tvState.turnDown();
    }
}
