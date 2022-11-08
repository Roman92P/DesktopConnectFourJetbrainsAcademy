import java.lang.annotation.Annotation;
import java.util.Arrays;

@Deprecated
class Abra {
    @Deprecated
    public String field;

    public Abra() {
    }
}

class AnnotationUtils {

//    public static void main(String[] args) {
//        printClassAnnotations(Abra.class);
//        printClassAnnotations("No input".getClass());
//    }

    public static void printClassAnnotations(Class classObject) {
        Arrays.stream(classObject.getDeclaredAnnotations())
                .forEach(annotation -> {
                    System.out.println(annotation.annotationType().getSimpleName());
                });
    }
}