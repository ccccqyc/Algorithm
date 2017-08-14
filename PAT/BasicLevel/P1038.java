import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by q on 17-8-14.
 */
public class P1038 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        String[] ints = bufferedReader.readLine().split(" ");
        String[] strings = bufferedReader.readLine().split(" ");
        bufferedReader.close();

        int[] count = new int[strings.length-1];
        for (int i = 1; i < strings.length; i++) {
            for (int j = 0; j < length; j++) {
                if (strings[i].equals(ints[j])){
                    count[i-1]++;
                }
            }

            System.out.print(count[i-1]);
            if (i != strings.length-1) {
                System.out.print(" ");
            }
        }
    }
}
