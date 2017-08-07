import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by q on 17-8-7.
 */
public class P1070 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] arrays = new int[length];
        for (int i = 0; i < length; i++) {
            arrays[i] = in.nextInt();
        }
        in.close();
        Arrays.sort(arrays);

        double num = arrays[0];
        for (int i = 1; i < length; i++) {
            num = (num + arrays[i]) / 2.0;
        }

        System.out.println((int)num);
    }
}
