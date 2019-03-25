package xwpeng.com.titerator.handler;

public class Handler2 extends Handler {
    @Override
    public int getHandleLevel() {
        return 2;
    }

    @Override
    protected void handle(Request request) {
     System.out.println("handle2 handle: " + request.getContent());
    }
}
