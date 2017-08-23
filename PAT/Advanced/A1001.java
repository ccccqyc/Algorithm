import java.util.Scanner;

/**
 * All pass.
 * Created by q on 17-8-23.
 */
public class A1001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        String c = String.valueOf(Math.abs(a + b));
        scanner.close();

        StringBuilder s = new StringBuilder("");
        int length = c.length();
        s.append(String.copyValueOf(c.toCharArray(), 0, length % 3));
        if (length % 3 != 0 && length > 3) {
            s.append(',');
        }
        for (int i = c.length() % 3; i < length; i += 3) {
            s.append(String.copyValueOf(c.toCharArray(), i, 3));
            if (i != length - 3) {
                s.append(',');
            }
        }
        if (a + b < 0) {
            s.insert(0, '-');
        }
        System.out.println(s);
    }
}
