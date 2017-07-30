import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by q on 17-7-28.
 * 运行超市...估计是java语言的问题
 */
public class P1047 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int peoNum = in.nextInt();
        in.nextLine();

        int[][] list = new int[peoNum][3];

        String[] strings = new String[3];
        for (int i = 0; i < peoNum; i++) {
            strings = in.nextLine().split("\\-| ");
            for (int j = 0; j < 3; j++) {
                list[i][j] = Integer.parseInt(strings[j]);
            }
        }


        int maxTeam = list[0][0];
        int maxCount = list[0][2];
        int count;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < peoNum; i++) {
            count = 0;
            if (set.add(list[i][0])) {
                for (int j = i; j < peoNum; j++) {
                    if (list[i][0] == list[j][0]) {
                        count += list[j][2];
                    }
                }
            }
            if (count >= maxCount) {
                maxCount = count;
                maxTeam = list[i][0];
            }
        }

        System.out.println(maxTeam + " " + maxCount);
    }
}
