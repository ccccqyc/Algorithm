import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * StringBuilder insert()
 * 字符数组 字符串 相互转换
 * chars → String
 * str = String.valueof(chars);
 *
 * String → chars
 * chars = str.toCharArray();
 *
 * 数组内部排序 Arrays.sort(chars);
 *
 */
public class A1069 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = null;
        try {
            str = new StringBuilder(reader.readLine());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str != null) {
            str.insert(0, "0000", 0, 4 - str.length());
        }

        char[] chars1;
        char[] chars2;
        int temp;
        do {
            chars1 = str.toString().toCharArray();
            Arrays.sort(chars1);
            chars2 = reservechar(chars1);
            temp = Integer.parseInt(String.valueOf(chars2)) - Integer.parseInt(String.valueOf(chars1));
            str = new StringBuilder(Integer.toString(temp));
            str.insert(0, "0000", 0, 4 - str.length());
            System.out.println(String.valueOf(chars2) + " - " + String.valueOf(chars1) + " = " + str.toString());
        } while (!str.toString().equals("0000") && !str.toString().equals("6174"));

    }

    /**
     * 0012 → 2100
     *
     * @param chars
     * @return
     */
    public static char[] reservechar(char[] chars) {
        char temp;
        char[] tempchars = chars.clone();
        for (int i = 0; i < 2; i++) {
            temp = tempchars[i];
            tempchars[i] = tempchars[chars.length - i - 1];
            tempchars[chars.length - i - 1] = temp;
        }

        return tempchars;
    }
}
