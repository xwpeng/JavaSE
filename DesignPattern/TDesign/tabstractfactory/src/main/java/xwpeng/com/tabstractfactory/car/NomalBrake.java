package xwpeng.com.tabstractfactory.car;

public class NomalBrake implements IBrake {
    @Override
    public void brake() {
        System.out.println("普通制动");
    }
}
