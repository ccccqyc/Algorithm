import java.util.Arrays;
import java.util.Scanner;

/**
 * 测试点3 超时.
 * Created by q on 17-9-5.
 */
public class P1060 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = scanner.nextInt();
        int[] ints = new int[days];
        for (int i = 0; i < days; i++) {
            ints[i] = scanner.nextInt();
        }
        scanner.close();

        int max = 0;
        Arrays.sort(ints);
        int count;
        for (int j = 1; j <= days; j++) {
            count = 0;
            for (int anInt : ints) {
                if (anInt > j) {
                    count++;
                    if (count == j) {
                        max = j;
                        break;
                    }
                }
            }
        }
        System.out.print(max);
    }
}
