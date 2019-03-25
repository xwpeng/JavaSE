package xwpeng.com.titerator.Leader;

public class Boss extends Leader {
    @Override
    protected int limit() {
        return Integer.MAX_VALUE;
    }

    @Override
    protected void handle(int money) {
        System.out.println("老板报销 " + money + " 元");

    }
}
