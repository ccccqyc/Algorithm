import java.util.Scanner;

/**
 * 死活说我的程序错误...
 * 不知道哪里错了....
 * 示例运行正确  估计是哪里格式错误..
 * 求请高人指点迷津..
 * Created by q on 17-9-4.
 */
public class P1052 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] strings = new String[3][];
        for (int i = 0; i < 3; i++) {
            strings[i] = scanner.nextLine().replace(" ", "").replace("]", "").replace(".", "").split("[\\[]");
        }
        int count = scanner.nextInt();
        int[][] ints = new int[count][5];
        int a = 0;
        StringBuilder[] out = new StringBuilder[count];

        for (int i = 0; i < count; i++) {
            out[i] = new StringBuilder("");
            for (int j = 0; j < 5; j++) {
                ints[i][j] = scanner.nextInt();
                if (ints[i][j] >= strings[a].length) {
                    out[i] = new StringBuilder("Are you kidding me? @\\/@\n");
                    break;
                } else {
                    out[i].append(strings[a][ints[i][j]]);
                    if (j == 0) {
                        a = 1;
                        out[i].append("(");
                    } else if (j == 1) {
                        a = 2;
                    } else if (j == 2) {
                        a = 1;
                    } else if (j == 3) {
                        a = 0;
                        out[i].append(")");
                    } else if (j == 4) {
                        a = 0;
                    }
                }
            }
        }
        scanner.close();

        for (int i = 0; i < count; i++) {
            System.out.print(out[i]);
            if (i != count-1) {
                System.out.print("\n");
            }
        }
    }
}
