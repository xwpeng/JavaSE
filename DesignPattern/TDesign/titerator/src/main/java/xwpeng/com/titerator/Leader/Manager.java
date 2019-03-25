package xwpeng.com.titerator.Leader;

public class Manager extends Leader {
    @Override
    protected int limit() {
        return 20000;
    }

    @Override
    protected void handle(int money) {
        System.out.println("经理报销 " + money + " 元");

    }
}
