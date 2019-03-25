package xwpeng.com.titerator.handler;

public class Handler3 extends Handler {
    @Override
    public int getHandleLevel() {
        return 3;
    }

    @Override
    protected void handle(Request request) {
     System.out.println("handle3 handle: " + request.getContent());
    }
}
