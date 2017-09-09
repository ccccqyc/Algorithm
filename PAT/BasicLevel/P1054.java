import java.util.Scanner;

/**
 * all pass
 * Created by q on 17-9-5.
 */
public class P1054 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        double sum = 0;
        int leng = 0;
        double aDouble;
        double temp;
        String s;
        for (int i = 0; i < count; i++) {
            s = scanner.next();
            try {
                aDouble = Double.parseDouble(s);
                temp = Double.parseDouble(String.format("%.2f", aDouble));
                if (aDouble < -1000 || aDouble > 1000 || Math.abs(aDouble - temp) >= 0.001) {
                    throw new NumberFormatException();
                }
                leng++;
                sum += aDouble;
            } catch (NumberFormatException e) {
                System.out.println("ERROR: " + s + " is not a legal number");
            }
        }
        scanner.close();

        if (leng == 0) {
            System.out.println("The average of 0 numbers is Undefined");
        } else if (leng == 1) {
            System.out.printf("The average of 1 number is %.2f", sum);
        } else {
            System.out.printf("The average of %d numbers is %.2f", leng, sum / leng);
        }
    }
}
