import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger m = new BigInteger(scanner.nextLine());
        System.out.println(factorialUsingForLoop(m));

    }


    public static long factorialUsingForLoop(BigInteger n) {
        BigInteger fact = BigInteger.ONE;
        BigInteger i = BigInteger.ONE;
        while (fact.compareTo(n) < 0) {
            i = i.add(BigInteger.ONE);
            fact = fact.multiply(i);

        }
        return i.longValue();
    }
}
