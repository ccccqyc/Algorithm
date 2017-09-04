import java.util.Scanner;

/**
 * all pass
 * Created by q on 17-9-4.
 */
public class P1048 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder s1 = new StringBuilder(scanner.next()).reverse();
        StringBuilder s2 = new StringBuilder(scanner.next()).reverse();
        StringBuilder stringBuilder = new StringBuilder("");
        int a;
        int b;
        String c;
        scanner.close();
        int max = Math.max(s1.length(), s2.length());
        for (int i = 0; i < max; i++) {

            //当s1,s2 的length不相同
            a = 0;
            b = 0;
            if (i < s2.length()) {
                a = Integer.parseInt(String.valueOf(s2.charAt(i)));
            }
            if (i < s1.length()) {
                b = Integer.parseInt(String.valueOf(s1.charAt(i)));
            }
            if (i % 2 == 0) {
                switch ((a + b) % 13) {
                    case 10: {
                        c = "J";
                        break;
                    }
                    case 11: {
                        c = "Q";
                        break;
                    }
                    case 12: {
                        c = "K";
                        break;
                    }
                    default: {
                        c = String.valueOf((a + b) % 13);
                        break;
                    }
                }
            } else {
                if (a - b < 0) {
                    c = String.valueOf(a - b + 10);
                } else {
                    c = String.valueOf(a - b);
                }
            }
            stringBuilder = stringBuilder.append(c);
        }
        System.out.print(stringBuilder.reverse());
    }
}
