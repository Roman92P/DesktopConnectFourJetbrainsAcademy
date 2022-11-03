import java.util.*;
import java.util.stream.Collectors;


class CollectorPalindrome {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        Map<Boolean, List<String>> palindromeOrNo = Arrays.stream(words)
                .collect(
                        Collectors.partitioningBy(word -> {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(word);
                            stringBuilder.reverse();
                            String s = stringBuilder.toString();
                            return s.equals(word);
                        })
                );

        palindromeOrNo = new LinkedHashMap<>(palindromeOrNo);

        System.out.println(palindromeOrNo);
    }
}