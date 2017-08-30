import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 测试5点 错误
 * Created by q on 17-8-28.
 */
public class P1024 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] ints = bufferedReader.readLine().split("[E]");
        bufferedReader.close();
        StringBuilder stringBuilder = new StringBuilder("");
        if (ints[0].charAt(0) == '-') {
            System.out.print("-");
        }

        ints[0] = ints[0].substring(1, ints[0].length());
        int decimalCount = ints[0].split("\\.")[1].length() - Integer.parseInt(ints[1]);
        if (decimalCount < 0) {
            decimalCount = 0;
        }
        System.out.printf("%." + decimalCount + "f", (Double.parseDouble(ints[0]) * Math.pow(10, Integer.parseInt(ints[1]))));

    }
}
