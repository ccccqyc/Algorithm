import java.io.IOException;
import java.util.Scanner;

/**
 * 测试点6超时
 * Created by q on 17-8-28.
 */
public class P1024 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[] ints = scanner.nextLine().split("[\\.E]");
        scanner.close();

        StringBuilder stringBuilder = new StringBuilder("");
        if (ints[0].charAt(0) == '-') {
            stringBuilder.append("-");
        }

        ints[0] = ints[0].substring(1, ints[0].length());
        int lengthDec = ints[1].length();
        int count10 = Integer.parseInt(ints[2]);
        if (count10 >= 0) {
            stringBuilder.append(ints[0]);
            if (count10 >= lengthDec) {
                stringBuilder.append(ints[1]);
                for (int i = count10 - lengthDec; i > 0; i--) {
                    stringBuilder.append("0");
                }
            } else if (count10 < lengthDec) {
                stringBuilder.append(ints[1].substring(0, count10) + "." + ints[1].substring(count10, lengthDec));
            }
        } else if (count10 < 0) {
            stringBuilder.append("0.");
            for (int i = -count10 - 1; i > 0; i--) {
                stringBuilder.append("0");
            }
            stringBuilder.append(ints[0] + ints[1]);
        }

        System.out.print(stringBuilder);

    }
}