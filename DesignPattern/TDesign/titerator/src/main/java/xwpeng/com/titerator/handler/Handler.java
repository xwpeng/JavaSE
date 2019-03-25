package xwpeng.com.titerator.handler;

public abstract class Handler {
    private Handler nextHandler;

    public final void handleRequest(Request request) {
        if (getHandleLevel() == request.getRequestLevel()) {
            handle(request);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("All of Handler can not handle the request!");
        }
    }

    protected abstract int getHandleLevel();

    protected abstract void handle(Request request);

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
