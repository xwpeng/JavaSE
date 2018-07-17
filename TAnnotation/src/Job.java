import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Jobs.class)
@Inherited
public @interface Job {
    String job() default "";
}
