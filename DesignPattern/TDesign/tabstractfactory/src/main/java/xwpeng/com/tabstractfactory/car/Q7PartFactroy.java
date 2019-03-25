package xwpeng.com.tabstractfactory.car;

public class Q7PartFactroy implements ICarPartFactory {

    @Override
    public ITire createTire() {
        return new SUVTire();
    }

    @Override
    public IEngine createEngine() {
        return new ImprotEngine();
    }

    @Override
    public IBrake createBrake() {
        return new SeniorBrake();
    }
}
