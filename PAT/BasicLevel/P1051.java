import java.util.Scanner;

/**
 * all pass
 * Created by q on 17-9-9.
 */
public class P1051 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double R1 = scanner.nextDouble();
        double P1 = scanner.nextDouble();
        double R2 = scanner.nextDouble();
        double P2 = scanner.nextDouble();
        scanner.close();

        double realPart = R1 * R2 * (Math.cos(P1) * Math.cos(P2) - Math.sin(P1) * Math.sin(P2));
        double imagePart = R1 * R2 * (Math.cos(P1) * Math.sin(P2) + Math.sin(P1) * Math.cos(P2));

        if (realPart > -0.005 && realPart <= 0) {
            System.out.print("0.00");
        } else {
            System.out.printf("%.2f", realPart);
        }
        if (imagePart > 0) {
            System.out.printf("+%.2fi", imagePart);
        } else if (Math.abs(imagePart) < 0.05) {
            System.out.print("+0.00i");
        } else {
            System.out.printf("%.2fi", imagePart);
        }

    }
}
