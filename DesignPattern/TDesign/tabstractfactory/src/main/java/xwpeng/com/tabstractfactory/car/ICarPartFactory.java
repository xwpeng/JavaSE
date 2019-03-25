package xwpeng.com.tabstractfactory.car;

public interface ICarPartFactory {
    ITire createTire();
    IEngine createEngine();
    IBrake createBrake();
}
