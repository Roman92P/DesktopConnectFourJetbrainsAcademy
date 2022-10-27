import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();

        // write your code here
        Pattern pattern = Pattern.compile(String.format("^[^a-zA-Z0-9]*[a-zA-Z]{%d}[^a-zA-Z0-9]*$", size));
        String[] arr = line.split("[\\s,]");

        long r = Arrays.stream(arr).filter(s -> {
            Matcher matcher = pattern.matcher(s);
            return matcher.matches();
        }).count();

        System.out.println(r > 0 ? "YES" : "NO");
    }
}