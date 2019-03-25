package xwpeng.com.tfactroy;

import android.view.View;

public class AConcreteFactroy extends AFactroy{


    @Override
    public <T extends Product> T createProduct(Class<T> clz) {
        Product t = null;
        try {
            t = (Product) Class.forName(clz.getName()).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T)t;
    }
}
