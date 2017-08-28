import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 测试点1234超时
 * Created by q on 17-8-28.
 */
public class P1040 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        bufferedReader.close();
        int offsetA;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'P') {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == 'A') {
                        offsetA = j;
                        sum += hasXNum(s, offsetA);
                    }
                }
            }
        }
        System.out.print(sum);
    }

    private static int hasXNum(String s, int begin) {
        int count = 0;
        for (int i = begin + 1; i < s.length(); i++) {
            if (s.charAt(i) == 'T') {
                count++;
            }
        }
        return count;
    }
}
