package xwpeng.com.titerator.Leader;

public class Director extends Leader {
    @Override
    protected int limit() {
        return 5000;
    }

    @Override
    protected void handle(int money) {
        System.out.println("主管报销 " + money + " 元");

    }
}
