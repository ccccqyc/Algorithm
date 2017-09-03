import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**全部超时...
 * 被迫 使用C++.
 * ...
 *
 * Created by q on 17-9-3.
 */
public class P1013 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.close();

        List<Integer> list = new LinkedList<>();
        for (int i = 2; list.size() != n; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        int cout = 1;
        for (int i = m - 1; i < n; i++) {
            System.out.print(list.get(i));
            if (cout % 10 == 0) {
                System.out.println();
            } else if (i != n - 1) {
                System.out.print(" ");
            }
            cout++;
        }
    }

    private static boolean isPrime(int n) {
        boolean b = true;
        for (int k = 2; k < n; k++) {
            if (n % 2 == 0 || n % k == 0) {
                b = false;
                break;
            }
        }
        return b;
    }
}
