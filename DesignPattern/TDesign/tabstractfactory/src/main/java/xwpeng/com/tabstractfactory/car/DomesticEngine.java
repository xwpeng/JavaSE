package xwpeng.com.tabstractfactory.car;

public class DomesticEngine implements IEngine{
    @Override
    public void run() {
        System.out.println("国产的发动机跑起来了");
    }
}
