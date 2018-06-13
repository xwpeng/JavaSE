

/**
 * 普通的泛型类
 *
 * @param <T>
 */
//此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
//在实例化泛型类时，必须指定T的具体类型
public class Generic<T> {

    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public Generic(T key) {//泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    public T getKey() {//泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public static void a() {
//泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
//传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        Generic<Integer> genericInteger = new Generic<>(123456);

//传入的实参类型需与泛型的类型参数类型相同，即为String.
        Generic<String> genericString = new Generic<>("key_vlaue");
        Main.log("泛型测试", "key is " + genericInteger.getKey());
        Main.log("泛型测试", "key is " + genericString.getKey());
    }

    public static void b() {
        Generic generic = new Generic("111111");
        Generic generic1 = new Generic(4444);
        Generic generic2 = new Generic(55.55);
        Generic generic3 = new Generic(false);

        Main.log("泛型测试","key is " + generic.getKey());
        Main.log("泛型测试","key is " + generic1.getKey());
        Main.log("泛型测试","key is " + generic2.getKey());
        Main.log("泛型测试","key is " + generic3.getKey());
        Generic<String> generic4 = new Generic<>("11");
    }

    public static void c() {
        Generic<?> generic = new Generic("ssss");
        if (generic.key instanceof String) {
            Main.log("泛型测试","key is " + generic.getKey());
        }
    }

    public static void showKeyValue1(Generic<Number> obj){
        Main.log("泛型测试","key value is " + obj.getKey());
    }

    public static void showKeyValue2(Generic<?> obj){
        Main.log("泛型测试","key value is " + obj.getKey());
    }

    public static void extend(Generic<? extends Number> obj){
        Main.log("泛型测试","key value is " + obj.getKey());
    }

    public static void superd(Generic<? super Integer> obj){
        Main.log("泛型测试","key value is " + obj.getKey());
    }

    /**
     * 如果在类中定义使用泛型的静态方法，需要添加额外的泛型声明（将这个方法定义成泛型方法）
     * 即使静态方法要使用泛型类中已经声明过的泛型也不可以。
     * 如：public static void show(T t){..},此时编译器会提示错误信息：
     "StaticGenerator cannot be refrenced from static context"
     */
//    public static T d(T t) {
//        return t;
//    }

}
