import java.util.Scanner;

/**
 * Created by q on 17-8-7.
 */
public class P1001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        in.close();

        int count = 0;
        while (m != 1) {
            if (m % 2 == 0) {
                m = m / 2;
            } else {
                m = (3 * m + 1) / 2;
            }
            count++;
        }
        System.out.println(count);

    }
}
