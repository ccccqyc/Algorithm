import java.util.Scanner;

/**
 * 测试点3,4超时
 * Created by q on 17-8-23.
 */
public class P1049 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        scanner.nextLine();

        float[] ints = new float[length];
        for (int i = 0; i < length; i++) {
            ints[i] = scanner.nextFloat();
        }
        scanner.close();

        float sum = 0;
        for (int i = 0; i < length; i++) {
            if (i == 0 || i == length - 1) {
                sum += ints[i] * length;
            } else {
                sum += ints[i] * (2 *length-2);
            }
        }
        System.out.printf("%.2f",sum);
    }
}
