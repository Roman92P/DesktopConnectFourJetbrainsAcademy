import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StreamUtils {

    public static Stream<Integer> generateStreamWithPowersOfTwo(int n) {
        int r = (int) Math.pow(2, n);
        return Stream.iterate(1, x -> x < r, x -> x * 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputPow = scanner.nextInt();
        Stream<Integer> result = generateStreamWithPowersOfTwo(inputPow);
        String str = result.map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(str);
    }
}