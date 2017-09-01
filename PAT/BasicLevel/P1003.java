import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * all pass
 * Created by q on 17-9-1.
 */
public class P1003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        scanner.nextLine();
        String[] strings = new String[length];
        boolean b = false;
        for (int i = 0; i < length; i++) {
            strings[i] = scanner.next();
            if (isPAT(strings[i])) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scanner.close();
    }

    private static boolean isPAT(String s) {
        boolean b = false;
        Pattern pattern = Pattern.compile("[A]*[P][A]+[T][A]*");
        if (!pattern.matcher(s).matches()) {
            return false;
        }

        int pIndex = s.indexOf('P');
        int tIndex = s.indexOf("T");
        int length = s.length();
        int rightA = length - tIndex - 1;
        int leftA = pIndex;
        int middleA = tIndex - pIndex - 1;
        if (leftA * middleA == rightA) {
            b = true;
        }
        return b;
    }

}
