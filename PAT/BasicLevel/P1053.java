import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by q on 17-8-14.
 */
public class P1053 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        float e = in.nextFloat();
        int valveDay = in.nextInt();

        List<String[]> list = new ArrayList<>();
        String[] ints;
        in.nextLine();
        for (int i = 0; i < num; i++) {
            ints = in.nextLine().split(" ");
            list.add(ints);
        }
        in.close();

        //每户空置天数
        int ifEmCo;
        //可能空置户数
        int mayEmNum = 0;
        //空置户数
        int EmNum = 0;

        for (Object aList : list) {
            ifEmCo = 0;
            ints = (String[]) aList;

            for (int i = 1; i < ints.length; i++) {
                if (Float.parseFloat(ints[i]) < e) {
                    ifEmCo++;
                }
            }

            if (ifEmCo * 2 > Integer.parseInt(ints[0])) {
                if (Integer.parseInt(ints[0]) <= valveDay) {
                    mayEmNum++;
                } else {
                    EmNum++;
                }
            }
        }
        System.out.printf("%.1f%% %.1f%%", 100 * mayEmNum / (float) num, 100 * EmNum / (float) num);
    }
}
