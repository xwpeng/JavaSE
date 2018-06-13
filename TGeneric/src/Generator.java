/**
 * 泛型接口
 * @param <T>
 */
public interface Generator<T> {
  T next(T t);
}
