import java.util.Scanner;

/**
 * all pass...
 * Created by q on 17-9-4.
 */
public class P1067 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.next();
        int count = scanner.nextInt();
        String s;
        scanner.nextLine();
        do {
            s = scanner.nextLine();
            if (s.equals("#")) {
                System.exit(0);
            }

            if (s.equals(password)) {
                System.out.println("Welcome in");
                break;
            } else if (!s.equals(password)) {
                count--;
                System.out.println("Wrong password: " + s);
                if (count == 0) {
                    System.out.println("Account locked");
                    System.exit(0);
                }
            }
        } while (scanner.hasNext());
        scanner.close();
    }
}
