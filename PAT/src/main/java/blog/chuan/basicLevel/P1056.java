package blog.chuan.basicLevel;

import java.util.Scanner;

/**
 * Created by q on 17-7-24.
 */
public class P1056 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();

        int result = 0;

        for (int i = 0; i < length; i++) {
            result += 11 * (length - 1) * in.nextInt();
        }
        System.out.println(result);
    }
}
