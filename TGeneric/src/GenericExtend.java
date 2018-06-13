

/**
 * 上边界限定符extends，限定泛型实参只能是某个类的子类
 *
 * @param <T>
 */
//此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
//在实例化泛型类时，必须指定T的具体类型
public class GenericExtend<T extends Number> {

    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public GenericExtend(T key) {//泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    public T getKey() {//泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

}
