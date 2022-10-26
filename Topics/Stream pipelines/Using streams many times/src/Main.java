import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.*;

class FunctionUtils {

    public static <T> Supplier<Stream<T>> saveStream(Stream<T> stream){
        List<T> intermediate = stream.collect(Collectors.toList());
        return new Supplier<Stream<T>>() {
            @Override
            public Stream<T> get() {
                return intermediate.stream();
            }
        };
    }
//    public static void main(String[] args) {
//        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
//        Supplier<Stream<Integer>> saved = saveStream(stream.filter(e -> e % 2 == 0));
//
//        System.out.println(saved.get().count());
//        System.out.println(saved.get().max(Integer::compareTo).get());
//        System.out.println(saved.get().min(Integer::compareTo).get());
//    }
}