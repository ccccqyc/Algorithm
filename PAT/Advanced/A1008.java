import java.util.Scanner;

/**
 * Elevator
 * All passed.
 * Created by q on 17-8-23.
 */
public class A1008 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            ints[i]= scanner.nextInt();
        }
        scanner.close();
        int sum = 5 * length +ints[0] * 6;
        for (int i = 1; i < ints.length; i++) {
            int c = ints[i]- ints[i - 1];
            if (c > 0) {
                sum += c * 6;
            } else {
                sum += -c * 4;
            }
        }
        System.out.print(sum);
    }
}
