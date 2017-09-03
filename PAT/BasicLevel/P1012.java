import java.util.Scanner;

/**
 * 全超时....
 * Created by q on 17-9-3.
 */
public class P1012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] ints = scanner.nextLine().split(" ");
        scanner.close();
        int a;
        int countA2 = 0;
        int countA4 = 0;
        int[] aCount = new int[5];
        for (String anInt : ints) {
            a = Integer.parseInt(anInt);
            if (a % 5 == 0 && a % 2 == 0) {
                aCount[0] += a;
            } else if (a % 5 == 1) {
                if (countA2 % 2 == 0) {
                    aCount[1] += a;
                } else {
                    aCount[1] -= a;
                }
                countA2++;
            } else if (a % 5 == 2) {
                aCount[2]++;
            } else if (a % 5 == 3) {
                aCount[3] += a;
                countA4++;
            } else if (a % 5 == 4) {
                if (a > aCount[4]) {
                    aCount[4] = a;
                }
            }
        }
        for (int i = 0; i < aCount.length; i++) {
            if (aCount[i] == 0) {
                System.out.print("N");
            } else if (i == 3) {
                System.out.printf("%.1f", aCount[3] / (float) countA4);
            } else {
                System.out.print(aCount[i]);
            }
            if (i != 4) {
                System.out.print(" ");
            }
        }
    }
}
