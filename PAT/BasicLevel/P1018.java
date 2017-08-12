import java.io.IOException;
import java.util.Scanner;

/**
 * Created by q on 17-8-12.
 */
public class P1018 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        in.nextLine();
        String[][] characters = new String[length][2];


        int aWin = 0;
        int aVb = 0;
        int bWin = 0;

        for (int i = 0; i < length; i++) {
            characters[i] = in.nextLine().split(" ");

            if (judge(characters[i][0], characters[i][1]) > 0) {
                aWin++;
            } else if (judge(characters[i][0], characters[i][1]) == 0) {
                aVb++;
            } else {
                bWin++;
            }

        }
        in.close();


        System.out.println(aWin + " " + aVb + " " + bWin);
        System.out.println(bWin + " " + aVb + " " + aWin);


    }

    private static int judge(String s1, String s2) {
        if ((s1.equals("C") && s2.equals("J")) || (s1.equals("J") && s2.equals("B")) || (s1.equals("B") && s2.equals("C"))) {
            return 1;
        } else if ((s1.equals("C") && s2.equals("C")) || (s1.equals("J") && s2.equals("J")) || (s1.equals("B") && s2.equals("B"))) {
            return 0;
        } else {
            return -1;
        }
    }
}
