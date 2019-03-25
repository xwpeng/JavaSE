package xwpeng.com.tfactroy;

public abstract  class AFactroy {
    public abstract <T extends Product> T createProduct(Class<T> clz);
}
