import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by q on 17-8-1.
 */
public class P1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        bufferedReader.close();

        int length = strings.length;
        for (int i = length - 1; i >= 0; i--) {
            if (i == 0) {
                System.out.print(strings[i]);
            } else {
                System.out.print(strings[i] + " ");
            }
        }
    }
}
