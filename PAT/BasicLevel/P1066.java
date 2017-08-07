import java.io.IOException;
import java.util.Scanner;

/**
 * Created by q on 17-8-7.
 */
public class P1066 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int rows = in.nextInt();
        int clomns = in.nextInt();
        int min = in.nextInt();
        int max = in.nextInt();
        int replace = in.nextInt();

        int[][] img = new int[rows][clomns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < clomns; j++) {
                img[i][j] = in.nextInt();
                if (img[i][j] >= min && img[i][j] <= max) {
                    img[i][j] = replace;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < clomns; j++) {
                if (j == clomns - 1) {
                    System.out.printf("%03d", img[i][j]);
                } else {
                    System.out.printf("%03d ", img[i][j]);
                }
            }
            if (i != rows - 1) {
                System.out.println();
            }
        }
        in.close();
    }
}
