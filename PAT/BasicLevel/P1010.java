import java.util.Scanner;

/**
 * all pass
 * Created by q on 17-9-3.
 */
public class P1010 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean printSpace = false;
        while (scanner.hasNext()) {
            int coefficient = scanner.nextInt();
            int exponent = scanner.nextInt();

            if (coefficient * exponent != 0) {
                if (printSpace) {
                    System.out.print(" ");
                } else {
                    printSpace = true;
                }
                System.out.print(coefficient * exponent + " " + (exponent - 1));
            }
        }
        scanner.close();
        if (!printSpace) {
            System.out.println("0 0");
        }
    }
}
