import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by q on 17-8-21.
 */
public class P1017 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BigInteger divisor = scanner.nextBigInteger();
        int dividend = scanner.nextInt();
        scanner.close();
        System.out.println(
                divisor.divide(BigInteger.valueOf(dividend)) + " " +
                        divisor.mod(BigInteger.valueOf(dividend)));

    }

}
