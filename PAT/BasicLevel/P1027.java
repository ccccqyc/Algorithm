import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by q on 17-8-11.
 */
public class P1027 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        in.close();

        int sum = 0;
        int row = 0;

        for (int i = 1; i < 23; i++) {
            if (sum > n) {
                row = i - 2;
                sum = 2 * (i - 2) * (i - 2) - 1;
                break;
            } else {
                sum = 2 * i * i - 1;
                row = i;
            }
        }

        List<StringBuilder> stringBuilders = new ArrayList<>();
        StringBuilder stringBuilder;
        for (int i = row; i > 0; i--) {
            stringBuilder = new StringBuilder("");
            for (int k = row - i; k > 0; k--) {
                stringBuilder.append(" ");
            }
            for (int j = 2 * i - 1; j > 0; j--) {
                stringBuilder.append(s);
            }
            stringBuilders.add(stringBuilder);
        }


        for (int i = row; i > 1; i--) {
            stringBuilders.add(stringBuilders.get(i - 2));
        }

        for (Object stringBuilder1 : stringBuilders) {
            System.out.println(stringBuilder1);
        }

        System.out.println(n - sum);

    }
}
