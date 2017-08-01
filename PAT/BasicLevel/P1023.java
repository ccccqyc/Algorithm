import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 排序
 * Created by q on 17-8-1.
 */
public class P1023 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        bufferedReader.close();

        int length = strings.length;
        String num = "";


        for (int i = 0; i < length; i++) {
            for (int j = 0; j < Integer.parseInt(strings[i]); j++) {
                num += i;
            }
        }
        int length2 = num.length();
        char[] characters = num.toCharArray();

        if (num.charAt(0) == '0') {
            for (int i = 0; i < num.length(); i++) {
                if (num.charAt(i) != '0') {
                    characters[0] = num.charAt(i);
                    characters[i] = '0';
                    break;
                }
            }
        }
        System.out.println(characters);

    }
}
