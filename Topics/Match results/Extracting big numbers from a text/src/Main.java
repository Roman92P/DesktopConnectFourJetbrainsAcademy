import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringWithNumbers = scanner.nextLine();

        Pattern javaPattern = Pattern.compile("\\d{10,}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(stringWithNumbers);

        while (matcher.find()) {
            String n1 = matcher.group();
            System.out.println(n1 + ":" + n1.length());
        }
    }
}