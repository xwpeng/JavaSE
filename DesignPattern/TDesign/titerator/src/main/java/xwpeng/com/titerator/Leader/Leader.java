package xwpeng.com.titerator.Leader;

public abstract class Leader {
    private Leader superLeader;

    public void setSuperLeader(Leader superLeader) {
        this.superLeader = superLeader;
    }

    public final void handleRequest(int money) {
        if (money <= limit()) {
            handle(money);
        } else if (superLeader != null) superLeader.handleRequest(money);
    }

    protected abstract int limit();

    protected abstract void handle(int money);


}
