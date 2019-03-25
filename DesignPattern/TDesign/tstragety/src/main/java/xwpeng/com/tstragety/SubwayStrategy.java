package xwpeng.com.tstragety;

public class SubwayStrategy implements CalculateStragety {
    @Override
    public int calculatePrice(int km) {
        if (km <= 6) return 3;
        if (km > 6 && km <= 12) return 4;
        if (km > 12 && km <= 22) return 5;
        return 6;
    }
}
