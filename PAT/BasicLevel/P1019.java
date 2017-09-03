import java.util.Arrays;
import java.util.Scanner;

/**
 * 全部超时....
 * 被迫使用C++...
 * Created by q on 17-9-3.
 */
public class P1019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();

        if (sortNum(num)[0] == sortNum(num)[1]) {
            System.out.println(num + " - " + num + " = " + "0000");
            System.exit(0);
        }

        while (num != 6174) {
            System.out.printf("%04d - %04d = ", sortNum(num)[1], sortNum(num)[0]);
            num = sortNum(num)[1] - sortNum(num)[0];
            System.out.printf("%04d\n", num);
        }
    }

    private static int[] sortNum(int num) {
        int[] ints = new int[2];
        //当nums<1000时,需要在高位添加"0"
        StringBuilder nums = new StringBuilder(String.valueOf(num));
        while (nums.length() != 4) {
            nums = new StringBuilder("0" + nums);
        }

        String[] s = nums.toString().split("");
        Arrays.sort(s);
        ints[0] = Integer.parseInt(s[0] + s[1] + s[2] + s[3]);
        ints[1] = Integer.parseInt(s[3] + s[2] + s[1] + s[0]);
        return ints;
    }
}
