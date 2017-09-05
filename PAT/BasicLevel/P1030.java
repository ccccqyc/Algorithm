import java.util.Arrays;
import java.util.Scanner;

/**
 * 超时测试点4.
 * p 和 数列中的数字最大值均10^9
 * 所以当 m<=n*p 不等式右边可能为10^18
 * 故需要用基本类型long.
 * Created by q on 17-9-5.
 */
public class P1030 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int p = scanner.nextInt();
        //一定用long
        long[] ints = new long[length];
        for (int i = 0; i < length; i++) {
            ints[i] = scanner.nextLong();
        }
        scanner.close();

        Arrays.sort(ints);
        long max = ints[length - 1];
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (max <= ints[i] * p) {
                count = length - i;
                break;
            }
        }
        System.out.print(count);
    }
}
