import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 测试点4超时..
 * Java一向如此
 * Created by q on 17-9-7.
 */
public class P1033 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] bads = scanner.nextLine().toLowerCase().toCharArray();
        char[] chars = scanner.nextLine().toCharArray();
        scanner.close();
        int lengthbad = bads.length;
        int lengthchar = chars.length;

        for (int i = 0; i < lengthbad; i++) {
            if (bads[i] == '+') {
                for (int j = 0; j < lengthchar; j++) {
                    if (chars[j] >= 65 && chars[j] <= 90) {
                        chars[j] = ' ';
                    }
                }
            } else {
                for (int j = 0; j < lengthchar; j++) {
                    if (chars[j] == bads[i]) {
                        chars[j] = ' ';
                    }
                }
            }
        }
        List<Character> list = new LinkedList<>();
        for (char c : chars) {
            if (c != ' ') {
                list.add(c);
            }
        }
        if (list.size() == 0) {
            System.out.println();
        }
        for (char c : list) {
            System.out.print(c);
        }
    }
}

