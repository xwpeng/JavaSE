package xwpeng.com.tfactroy.car;

public class AudiCarFactroy extends AudiFactory{
    @Override
    public <T extends AudiCar> T createAudicar(Class<T> clz) {
        AudiCar audiCar = null;
        try {
          audiCar = (AudiCar) Class.forName(clz.getName()).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) audiCar;
    }
}
