import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int newScale = scanner.nextInt();
        BigDecimal bd = new BigDecimal(s);

        if (!bd.setScale(newScale, RoundingMode.HALF_UP).equals(bd.setScale(newScale, RoundingMode.HALF_DOWN))) {
            System.out.println(bd.setScale(newScale, RoundingMode.HALF_DOWN));
        } else {
            System.out.println(bd.setScale(newScale, RoundingMode.HALF_UP));
        }
    }
}