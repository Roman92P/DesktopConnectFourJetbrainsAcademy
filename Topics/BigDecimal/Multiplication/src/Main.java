import java.math.BigDecimal;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        BigDecimal bd1 = scanner.nextBigDecimal();
        BigDecimal bd2 = scanner.nextBigDecimal();

        System.out.println(bd1.multiply(bd2));
    }
}