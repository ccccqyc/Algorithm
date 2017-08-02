import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by q on 17-8-1.
 */
public class P1036 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        bufferedReader.close();

        int edge = Integer.parseInt(s.split(" ")[0]);
        char c = s.split(" ")[1].charAt(0);

        //Math.round Java中针对小数部分四舍五入
        for (int j = 0; j < Math.round(edge / 2.0); j++) {
            for (int i = 0; i < edge; i++) {
                if (j == 0 || j == Math.round(edge / 2.0) - 1) {
                    System.out.print(c);
                } else {
                    if (i == 0 || i == edge - 1) {
                        System.out.print(c);
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
