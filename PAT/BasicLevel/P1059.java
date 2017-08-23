import java.util.Scanner;

/**
 * 测试点2,3超时.
 * Created by q on 17-8-23.
 */
public class P1059 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length1 = scanner.nextInt();
        int[][] nums = new int[length1][2];
        for (int i = 0; i < length1; i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = 1;
        }
        int length2 = scanner.nextInt();
        int[][] search = new int[length2][2];
        for (int i = 0; i < length2; i++) {
            search[i][0] = scanner.nextInt();
            search[i][1] = 0;
        }
        scanner.close();
        for (int i = 0; i < length2; i++) {
            System.out.printf("%04d: ", search[i][0]);
            for (int j = 0; j < length1; j++) {
                if (search[i][0] == nums[j][0]) {
                    if (nums[j][1] == 1) {
                        if (isPrime(j + 1) && j != 0) {
                            search[i][1] = 3;
                        } else {
                            search[i][1] = 1;
                        }
                        nums[j][1]--;
                    } else if (nums[j][1] == 0) {
                        search[i][1] = 2;
                    }
                    break;
                }
            }
            if (search[i][1] == 0) {
                System.out.println("Are you kidding?");
            } else if (search[i][1] == 1) {
                if (search[i][0] == nums[0][0]) {
                    System.out.println("Mystery Award");
                } else {
                    System.out.println("Chocolate");
                }
            } else if (search[i][1] == 2) {
                System.out.println("Checked");
            } else if (search[i][1] == 3) {
                System.out.println("Minion");
            }
        }
    }

    private static boolean isPrime(int n) {
        boolean b = true;
        for (int i = 2; i < n; i++) {
            if (n % 2 == 0 || n % i == 0) {
                b = false;
                break;
            }
        }
        return b;
    }
}
