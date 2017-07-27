import java.util.Scanner;

/**
 * Created by q on 17-7-27.
 */
public class P1063 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cout = scanner.nextInt();

        double[] list2 = new double[cout];
        double max = 0;
        for (int i = 0; i < cout; i++) {
            list2[i] = Math.pow(scanner.nextInt(), 2) + Math.pow(scanner.nextInt(), 2);

            if (list2[i] > max) {
                max = list2[i];
            }
        }
        System.out.printf("%.2f", Math.sqrt(max));
    }
}
