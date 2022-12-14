import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();

        // write your code here
        Pattern pattern = Pattern.compile(".+" + part.toLowerCase() + ".+");
        String[] arr = line.split(" ");
        boolean matches = false;
        for (int i = 0; i < arr.length; i++) {
            Matcher matcher = pattern.matcher(arr[i].toLowerCase());
            matches = matcher.matches();
            if (matches) break;
        }
        System.out.println(matches? "YES" : "NO");
    }
}