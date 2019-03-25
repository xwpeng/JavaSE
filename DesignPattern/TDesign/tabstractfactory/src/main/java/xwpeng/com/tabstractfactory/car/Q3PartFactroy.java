package xwpeng.com.tabstractfactory.car;

public class Q3PartFactroy implements ICarPartFactory {

    @Override
    public ITire createTire() {
        return new NomalTire();
    }

    @Override
    public IEngine createEngine() {
        return new DomesticEngine();
    }

    @Override
    public IBrake createBrake() {
        return new NomalBrake();
    }
}
