package xwpeng.com.tfactroy.car;

public class AudiQ7 extends AudiCar {
    @Override
    public void drive() {
        System.out.println("Q7 启动了");
    }

    @Override
    public void selfNavigation() {
        System.out.println("Q7 自动驾驶中");
    }
}
