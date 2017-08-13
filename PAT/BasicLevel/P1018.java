import java.util.Scanner;

/**
 * Created by q on 17-8-12.
 */
public class P1018 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        in.nextLine();
        String[][] characters = new String[length][2];

        int aWin = 0;
        int aVb = 0;
        int bWin = 0;
        int[] aJCB = new int[3];
        int[] bJCB = new int[3];

        for (int i = 0; i < length; i++) {
            characters[i] = in.nextLine().split(" ");

            if (judge(characters[i][0], characters[i][1]) > 0) {
                aWin++;
                add(aJCB, characters[i][0]);
            } else if (judge(characters[i][0], characters[i][1]) == 0) {
                aVb++;
            } else {
                bWin++;
                add(bJCB, characters[i][1]);
            }
        }
        in.close();

        System.out.println(aWin + " " + aVb + " " + bWin);
        System.out.println(bWin + " " + aVb + " " + aWin);
        System.out.print(print(aJCB) + " " + print(bJCB));

    }

    private static int judge(String s1, String s2) {
        if ((
                s1.equals("C") && s2.equals("J")) ||
                (s1.equals("J") && s2.equals("B")) ||
                (s1.equals("B") && s2.equals("C"))) {
            return 1;
        } else if ((
                s1.equals("C") && s2.equals("C")) ||
                (s1.equals("J") && s2.equals("J")) ||
                (s1.equals("B") && s2.equals("B"))) {
            return 0;
        } else {
            return -1;
        }
    }

    private static void add(int[] ints, String string) {
        switch (string) {
            case "J":
                ints[0]++;
                break;
            case "C":
                ints[1]++;
                break;
            case "B":
                ints[2]++;
                break;
        }
    }

    private static String print(int[] ints) {
        String s = "";
        int max = Math.max(ints[0], Math.max(ints[1], ints[2]));
        if ((
                ints[0] == ints[1] && ints[0] == ints[2]) ||
                (ints[0] == ints[1] && ints[0] < ints[2]) ||
                (ints[0] > ints[1] && ints[0] == ints[2]) ||
                (ints[0] < ints[1] && ints[1] == ints[2]) ||
                ints[2] == max
                ) {
            s = "B";
        } else if ((
                ints[0] == ints[1] && ints[0] > ints[2]) ||
                (ints[0] < ints[1] && ints[0] == ints[2]) ||
                ints[1] == max
                ) {
            s = "C";
        } else if ((
                ints[2] == ints[1] && ints[0] > ints[1]) ||
                ints[0] == max
                ) {
            s = "J";
        }
        return s;
    }
}
