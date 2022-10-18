import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        BigDecimal bd1 = scanner.nextBigDecimal();
        BigDecimal bd2 = scanner.nextBigDecimal();
        BigDecimal bd3 = scanner.nextBigDecimal();

        BigDecimal result = ((bd1.add(bd2)).add(bd3)).divide(new BigDecimal("3"),0,RoundingMode.HALF_EVEN);
        System.out.println(result);
    }
}