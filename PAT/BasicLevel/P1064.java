import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by q on 17-8-3.
 */
public class P1064 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = bufferedReader.read();

        String[] strings = bufferedReader.readLine().split(" ");

        int friends = 0;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < strings[i].length(); j++) {
                friends += Integer.parseInt(String.valueOf(strings[i].charAt(j)));
            }


        }
    }
}
