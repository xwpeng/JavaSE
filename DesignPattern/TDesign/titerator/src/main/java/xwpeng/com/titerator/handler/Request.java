package xwpeng.com.titerator.handler;

public abstract class Request {
    private Object object;

    public Request(Object o) {
        this.object = o;
    }

    public Object getContent() {
        return object;
    }

    public abstract int getRequestLevel();

}
