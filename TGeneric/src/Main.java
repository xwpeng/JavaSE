import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        a();
//        b();
//        Generic.a();
//        Generic.b();
//        Generic.c();
//        c();
        GenericMethod.a();
    }

    private static void a() {
        List arrayList = new ArrayList();
        arrayList.add("aaaa");
        arrayList.add(100);

        for (int i = 0; i < arrayList.size(); i++) {
            Object item =  arrayList.get(i);
            log("泛型测试", "item = " + item);
        }
    }

    private static void b() {
        List<String> stringArrayList = new ArrayList<>();
        List<Integer> integerArrayList = new ArrayList<>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if(classStringArrayList.equals(classIntegerArrayList)){
            log("泛型测试","类型相同");
        }
    }

    public static void c() {
        Generic<Integer> gInteger = new Generic<Integer>(123);
        Generic<Number> gNumber = new Generic<Number>(456);
//        Generic.showKeyValue1(gInteger); 不能这样写
        Generic.showKeyValue1(gNumber);
        Generic.showKeyValue2(gInteger);
        Generic.showKeyValue2(gNumber);
    }

    public static void log(String tag, String message) {
        System.out.println(tag + "-->   " + message);
    }

    public static void d() {
    /**
     * 错误，Object不是Number的子类
     */
//    GenericExtend<Object> a = new GenericExtend<Object>(11);
    /**
     *  正确，Integer是Number的子类
     */
    GenericExtend<Integer> b = new GenericExtend<>(11);
    /**
     * 错误，即使是通配符在实际通配时也要受到限定
     */
//    GenericExtend<?> c = new GenericExtend<>("ss");
    /**
     * 正确，通配符在实际通配时受到了限定
     */
    GenericExtend<?> d = new GenericExtend<>(1.01);
    }

    /**
     * 泛型数组
     */
    public static void e() {
//        List<String>[] ls = new ArrayList<String>[10];//不可以
        List<?>[] ls1 = new ArrayList<?>[10];
        List<String>[] ls2 = new ArrayList[10];
        List[] ls3 = new ArrayList[10];
    }
}
