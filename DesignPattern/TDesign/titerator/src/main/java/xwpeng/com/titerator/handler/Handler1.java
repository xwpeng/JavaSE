package xwpeng.com.titerator.handler;

public class Handler1 extends Handler {
    @Override
    public int getHandleLevel() {
        return 1;
    }

    @Override
    protected void handle(Request request) {
     System.out.println("handle1 handle: " + request.getContent());
    }

}
