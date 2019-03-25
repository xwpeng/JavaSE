package xwpeng.com.tabstractfactory.car;

public class SUVTire implements ITire {
    @Override
    public void getCode() {
        System.out.println("越野轮胎");
    }
}
