import java.util.Scanner;

/**
 * Created by q on 17-7-29.
 */
public class P1006 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        in.close();

        for (int i = 0; i < num / 100; i++) {
            System.out.print("B");
        }
        for (int i = 0; i < (num / 10) % 10; i++) {
            System.out.print("S");
        }
        for (int i = 0; i < num % 10; i++) {
            System.out.print(i + 1);
        }

    }
}
