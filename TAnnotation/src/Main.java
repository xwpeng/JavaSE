public class Main {
    public static void main(String[] args) {
        boolean hasAnnotation = Test.class.isAnnotationPresent(Jobs.class);
        if (hasAnnotation) {
            Jobs jobs = Test.class.getAnnotation(Jobs.class);
            System.out.println(jobs.value()[0].job());
        }
    }
}
