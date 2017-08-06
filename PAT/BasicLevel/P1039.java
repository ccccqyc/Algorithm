import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by q on 17-8-5.
 */
public class P1039 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] chars1 = bufferedReader.readLine().split("");
        String[] chars2 = bufferedReader.readLine().split("");

        int lengthChars1 = chars1.length;
        int lengthChars2 = chars2.length;

        for (String char2 : chars2) {
            for (int i=0;i<lengthChars1;i++) {
                if (char2.equals(chars1[i])) {
                    chars1[i] = "";
                    lengthChars2--;
                    break;
                }
            }
        }

        if (lengthChars2 == 0) {
            System.out.print("Yes" + " " + (lengthChars1 - chars2.length));
        } else {
            System.out.print("No" + " " + lengthChars2);
        }

    }
}
