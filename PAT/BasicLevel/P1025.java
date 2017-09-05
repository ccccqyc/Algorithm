import java.util.Scanner;

/**
 * 不知道哪错了..
 * 没有通过程序.
 * 除了一个超时,其余全部错误
 * Created by q on 17-9-5.
 */
public class P1025 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int size = scanner.nextInt();
        int num = scanner.nextInt();
        scanner.nextLine();
        String[] stringsTemp;
        String[][] strings = new String[size][];
        for (int i = 0; i < size; i++) {
            stringsTemp = scanner.nextLine().split(" ");
            strings[Integer.parseInt(stringsTemp[1]) - 1] = stringsTemp;
        }
        scanner.close();

        for (int j = 0; j < size / num; j++) {
            for (int i = num * j; i < (j * num + num / 2); i++) {
                stringsTemp = strings[i];
                strings[i] = strings[(2*j + 1) * num - 1 - i];
                strings[(2*j + 1) * num - 1 - i] = stringsTemp;
            }
        }

        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                strings[i][2] = "-1";
            } else {
                strings[i][2] = strings[i + 1][0];
            }
            System.out.print(strings[i][0] + " " + strings[i][1] + " " + strings[i][2]);
            if (i != size - 1) {
                System.out.print("\n");
            }
        }
    }
}
