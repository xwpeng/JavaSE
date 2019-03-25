package xwpeng.com.tstragety;

public class BusStragety implements CalculateStragety {
    @Override
    public int calculatePrice(int km) {
        int extraTotal = km - 10;
        int extraFactor = extraTotal / 5;
        int faction = extraTotal % 5;
        int price = 1 + extraFactor;
        return faction > 0 ? ++price : price;
    }
}
