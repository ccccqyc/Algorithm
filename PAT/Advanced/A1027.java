import java.util.Scanner;

/**
 * 十进制转换
 * all passed
 * Created by q on 17-9-20.
 */
public class A1027 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = "0123456789ABC".toCharArray();
        int num;
        System.out.print("#");
        for (int i = 0; i < 3; i++) {
            num = scanner.nextInt();
            System.out.printf("%s%s", chars[num / 13], chars[num % 13]);
        }
        scanner.close();
    }
}
