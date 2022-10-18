import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int power = scanner.nextInt();
        int scale = scanner.nextInt();
        BigDecimal bd = scanner.nextBigDecimal();

        BigDecimal bd1 = bd.setScale(scale, RoundingMode.FLOOR);

        System.out.println(bd1.pow(power));
    }
}