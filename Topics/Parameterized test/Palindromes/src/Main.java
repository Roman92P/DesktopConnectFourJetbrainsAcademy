import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class StringUtils {
    public static boolean isPalindrome(String str) {
        // your code here
        if (str.isBlank() || str.replaceAll("[\\W]", "").isBlank()) {
            return false;
        }
        String[] tempArr = str.split("");
        List<String> l = Arrays.stream(tempArr).map(String::toLowerCase).collect(Collectors.toList());
        Collections.reverse(l);
        String finalStr = l.toString().replaceAll("[\\[\\],\\s\\W]","");
        return finalStr.equals(str.toLowerCase().replaceAll("[\\s\\W]",""));
    }
}