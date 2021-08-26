import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 有点考察数学的意思.
 * 分析: https://www.liuchuo.net/archives/2110
 *
 * 1.质数或者1时,输出只会是1
 * 2.一个数的因数最大为 sqrt(num)+1
 * 3.设置俩个变量len 长度,first 首个数
 *
 * 261 ms
 */
public class A1096 {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = 0, first = 0, maxn, len = 0, temp ;
        try {
            num = Integer.parseInt(bufferedReader.readLine());
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        maxn = (int) Math.sqrt(num) + 1;

        for (int i = 2; i <= maxn; i++) {
            int j;
            temp = 1;
            for (j = i; j <= maxn; j++) {
                temp *= j;
                if (num % temp != 0) break;
            }

            if (j - i > len) {
                len = j - i;
                first = i;
            }
        }
        if (first == 0) {
            System.out.print(1 + "\n" + num);
        } else {
            System.out.println(len);
            for (int i = 0; i < len; i++) {
                System.out.print(first + i);
                if (i != len - 1) System.out.print("*");
            }
        }
    }

}
