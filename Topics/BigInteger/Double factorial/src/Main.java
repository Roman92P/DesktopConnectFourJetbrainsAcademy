import java.math.BigInteger;

class DoubleFactorial {
    public static BigInteger calcDoubleFactorial(int n) {
        // type your java code here
        if (n <= 0) {
            return BigInteger.ONE;
        }
//        long result = 1;
//        for (int i = n; i > 0 ; i -= 2) {
//            result = result * i;
//        }
        long result = n * Long.parseLong(calcDoubleFactorial(n-2).toString());
        return BigInteger.valueOf(result);
    }
}