import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by q on 17-8-21.
 */
public class P1017 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        bufferedReader.close();
        String string1 = strings[0];
        int divisor = Integer.parseInt(strings[1]);
        int length = string1.length();
        //商
        StringBuilder quotient = new StringBuilder("");
        //余数
        StringBuilder residue = new StringBuilder("0");
        int temp;
        char[] string1C = string1.toCharArray();
        String[] stringTemp;
        for (int i = 0; i < length; i++) {
            temp = Integer.parseInt(String.valueOf(residue.append(new StringBuilder(String.copyValueOf(string1C, i, 1)))));
            if (i != 0
                    &&
                    Integer.parseInt(String.valueOf(residue)) < divisor
                    &&
                    String.valueOf(residue).length() == 2
                    ) {
                quotient.append("0");
            }
            if (temp < divisor) {
                temp = Integer.parseInt(String.valueOf(residue.append(new StringBuilder(String.copyValueOf(string1C, i + 1, 1)))));
                i++;
            }
            stringTemp = getResidue(temp, divisor);
            quotient.append(stringTemp[0]);
            residue = new StringBuilder(stringTemp[1]);
        }
        System.out.print(quotient + " " + residue);
    }

    private static String[] getResidue(int temp, int divisor) {
        String[] residue = new String[2];
        //商
        residue[0] = String.valueOf(temp / divisor);
        //余数
        residue[1] = String.valueOf(temp % divisor);
        return residue;
    }
}
