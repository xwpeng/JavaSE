package xwpeng.com.tfactroy.car;

public abstract class AudiFactory {
    public abstract <T extends AudiCar> T createAudicar(Class<T> clz);
}
