import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();

        String lcLine = line.toLowerCase();
        String lcPart = part.toLowerCase();
        Pattern pattern = Pattern.compile(String.format(
                "^(?:.+[^0-9a-zA-Z]+%s.*|" +
                        "(?:%s[a-zA-Z0-9]+[^a-zA-Z0-9]+.*|" +
                        ".*%s[^0-9a-zA-Z].*" +
                        "|.*%s))$",
                lcPart, lcPart, lcPart, lcPart));
        Matcher matcher = pattern.matcher(lcLine);
        System.out.println(matcher.matches() ? "YES" : "NO");
    }
}