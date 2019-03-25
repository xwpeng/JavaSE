package xwpeng.com.tabstractfactory.car;

public class NomalTire implements ITire {
    @Override
    public void getCode() {
        System.out.println("普通轮胎");
    }
}
