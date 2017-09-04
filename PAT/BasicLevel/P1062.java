import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 又不知哪里没有考虑完全...
 * 测试点3 错误..
 * Created by q on 17-9-4.
 */
public class P1062 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] string = scanner.nextLine().replace("/", " ").split(" ");
        scanner.close();

        int[] ints = new int[5];
        for (int i = 0; i < 5; i++) {
            ints[i] = Integer.parseInt(string[i]);
        }
        double a = Math.ceil(ints[0] * ints[4] / (float) ints[1]);
        double b = Math.floor(ints[2] * ints[4] / (float) ints[3]);
        if (a > b) {
            double temp = a;
            a = b;
            b = temp;
        }

        List<Integer> list = new LinkedList<>();
        for (int i = (int) a; i <= b; i++) {
            if (hasComDivr(ints[4], i)) {
                list.add(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "/" + ints[4]);
            if (i != list.size() - 1) {
                System.out.print(" ");
            }
        }
    }

    private static boolean hasComDivr(int m, int n) {
        boolean b = true;
        for (int i = 2; i < m; i++) {
            if (n % i == 0 && m % i == 0) {
                b = false;
                break;
            }
        }
        return b;
    }
}
