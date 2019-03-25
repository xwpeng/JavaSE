package xwpeng.com.titerator.handler;

public class Request1 extends Request {
    public Request1(Object o) {
        super(o);
    }

    @Override
    public int getRequestLevel() {
        return 1;
    }
}
