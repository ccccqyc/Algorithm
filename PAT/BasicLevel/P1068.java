import java.util.Scanner;

/**
 * 不知道 哪里错了...
 * 3,5测试点过不了.
 * 4测试点内存超限.
 * Created by q on 17-9-4.
 */
public class P1068 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int tol = scanner.nextInt();
        int[][] ints = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ints[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        int count = 0;
        int coordinateX = 0;
        int coordinateY = 0;
        int num = 0;

        c:
        for (int i = 1; i < m - 1; i++) {
            d:
            for (int j = 1; j < n - 1; j++) {
                for (int k = -1; k <= 1; k++) {
                    for (int g = -1; g <= 1; g++) {
                        if (ints[i][j] - ints[i + k][j + g] <= tol && (k != 0 && g != 0)) {
                            continue d;
                        }
                    }
                }

                count++;
                if (count > 1) {
                    break c;
                }
                coordinateX = i;
                coordinateY = j;
                num = ints[i][j];
            }
        }

        if (count == 1) {
            System.out.print("(" + (coordinateY + 1) + ", " + (coordinateX + 1) + ")" + ": " + num);
        } else if (count > 1) {
            System.out.print("Not Unique");
        } else if (count == 0) {
            System.out.print("Not Exist");
        }
    }
}
