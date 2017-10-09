import java.util.Scanner;

/**
 * 全部测试点 超时
 * Created by q on 17-10-9./home/q/IDEA/Algorithm
 */
public class A1092 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String buyString = scanner.nextLine();
        String evaString = scanner.nextLine();

        scanner.close();

        char[] buyChar = buyString.toCharArray();

        int buyLength = buyString.length();
        int evaLength = evaString.length();
        int count = 0;
        for (int i = 0; i < evaLength; i++) {
            for (int j = 0; j < buyLength; j++) {
                if (evaString.charAt(i) == buyChar[j]) {
                    buyChar[j] = ' ';
                    count++;
                    break;
                }
            }
        }

        if (count == evaLength) {
            System.out.print("Yes " + (buyLength - evaLength));
        } else {
            System.out.print("No " + (evaLength - count));
        }
    }
}
