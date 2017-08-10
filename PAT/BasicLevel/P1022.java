import java.io.IOException;
import java.util.Scanner;

/**
 * Created by q on 17-8-10.
 */
public class P1022 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt() + in.nextInt();
        int D = in.nextInt();
        in.close();
        StringBuilder stringBuilder = radix(A, D).reverse();
        System.out.print(stringBuilder);
    }

    private static StringBuilder radix(int num, int radix) {
        StringBuilder stringBuilder = new StringBuilder("");

        while (num >= radix) {
            stringBuilder.append(num % radix);
            num /= radix;
        }
        stringBuilder.append(num);
        return stringBuilder;
    }

}
