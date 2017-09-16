import java.util.Scanner;

/**
 * all passed
 * Created by q on 17-9-15.
 */
public class L1_002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String sign = scanner.next();
        scanner.close();

        boolean isContinue = true;
        int i = 1;
        int sum = 1;
        while (isContinue) {
            if (count == 1) {
                break;
            }
            if (sum < count) {
                i++;
            } else {
                i--;
                isContinue = false;
            }
            sum = 2 * i * i - 1;
        }

        int printC;
        String[] printOut = new String[2 * i - 1];
        int space;
        StringBuilder stringBuilder;
        for (int j = 0; j <= printOut.length / 2; j++) {
            stringBuilder = new StringBuilder("");
            space = j;
            for (int k = 0; k < space; k++) {
                stringBuilder.append(" ");
            }
            printC = 2 * (i - j) - 1;
            while (printC != 0) {
                stringBuilder.append(sign);
                printC--;
            }
            printOut[j] = stringBuilder.toString();
            printOut[2 * i - 1 - j - 1] = printOut[j];
        }
        for (String aPrintOut : printOut) {
            System.out.println(aPrintOut);
        }
        System.out.println(count - sum);
    }
}
