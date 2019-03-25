package xwpeng.com.tfactroy;

public class ConcreteFactroy extends Factroy{

    @Override
    Product createProduct() {
        return new ConcreteProductA();
    }
}
