import java.util.Scanner;

/**
 * Created by q on 17-8-13.
 */
public class P1032 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        in.nextLine();

        int[][] ints = new int[length][2];
        String[] strings;

        int maxNum = 0;
        for (int i = 0; i < length; i++) {
            strings = in.nextLine().split(" ");
            ints[i][0] = Integer.parseInt(strings[0]);
            ints[i][1] = Integer.parseInt(strings[1]);
            if (maxNum < ints[i][0]) {
                maxNum = ints[i][0];
            }
        }
        in.close();

        int[] theMax;
        theMax = new int[maxNum];
        int maxT = 0;
        int maxN = 0;
        for (int i = 0; i < maxNum; i++) {
            for (int j = 0; j < length; j++) {
                if ((i + 1) == ints[j][0]) {
                    theMax[i] += ints[j][1];
                }
            }
            if (theMax[i] > maxN) {
                maxN = theMax[i];
                maxT = i + 1;
            }
        }
        System.out.print(maxT + " " + maxN);
    }
}
