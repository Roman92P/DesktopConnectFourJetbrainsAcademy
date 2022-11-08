import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 Get an array of fields the object declares that contain annotations (inherited fields should be skipped).
 */
class Abra {
    @Deprecated
    public String field;

    public Abra() {}
}

class AnnotationsUtil {

    public static String[] getFieldsContainingAnnotations(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        List<String> list = Arrays.stream(fields)
                .filter(field -> field.getDeclaredAnnotations().length>0)
                .map(Field::getName)
                .collect(Collectors.toList());
        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

}