import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 测试点5 超时.
 * Created by q on 17-8-23.
 */
public class P1007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        List<Integer> list = new LinkedList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        int length = list.size();
        int count = 0;
        for (int i = 0; i < length - 1; i++) {
            if (list.get(i + 1) - list.get(i) == 2) {
                count++;
            }
        }
        System.out.print(count);
    }

    private static boolean isPrime(int n) {
        boolean b = true;
        for (int i = 2; i < n; i++) {
            if (n % 2 == 0 || n % i == 0) {
                b = false;
                break;
            }
        }
        return b;
    }
}
