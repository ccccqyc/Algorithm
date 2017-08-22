import java.math.BigInteger;
import java.util.Scanner;

/**
 * 测试点全部超时
 * Created by q on 17-8-22.
 */
public class P1017 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger divisor = scanner.nextBigInteger();
        int dividend = scanner.nextInt();
        scanner.close();
        System.out.println(
                divisor.divide(BigInteger.valueOf(dividend)) + " " +
                divisor.mod(BigInteger.valueOf(dividend))
        );
    }
}
