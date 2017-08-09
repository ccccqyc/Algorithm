import java.util.Scanner;

/**
 * Created by q on 17-8-7.
 */
public class P1031 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        String[][] s = new String[length][18];
        in.nextLine();
        for (int i = 0; i < length; i++) {
            s[i] = in.nextLine().split("");
        }

        int count = length;
        c:
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < 17; j++) {
                if (!Character.isDigit(s[i][j].charAt(0))) {
                    continue c;
                }
            }
            if (s[i][17].equals(map(verify(s[i])))) {
                count--;
                s[i] = null;
            }
        }

        if (count == 0) {
            System.out.println("All passed");
        } else {
            for (int i = 0; i < length; i++) {
                if (s[i] != null) {
                    for (int j = 0; j < 18; j++) {
                        System.out.print(s[i][j]);
                    }
                }
                if (i != length - 1) {
                    System.out.println();
                }
            }
        }

    }

    private static int verify(String[] s) {

        int[] v = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

        int mod = 0;
        for (int i = 0; i < 17; i++) {
            mod += Integer.parseInt(s[i]) * v[i];
        }
        return mod % 11;
    }

    private static String map(int mod) {
        switch (mod) {
            case 0:
                return "1";
            case 1:
                return "0";
            case 2:
                return "X";
            case 3:
                return "9";
            case 4:
                return "8";
            case 5:
                return "7";
            case 6:
                return "6";
            case 7:
                return "5";
            case 8:
                return "4";
            case 9:
                return "3";
            case 10:
                return "2";
        }
        return "";
    }
}
