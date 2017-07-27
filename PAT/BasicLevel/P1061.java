import java.util.Scanner;

/**
 * Created by q on 17-7-27.
 */
public class P1061 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentCount = scanner.nextInt();
        int titleCount = scanner.nextInt();

        //学生
        Integer[][] list = new Integer[studentCount][titleCount];

        //分值
        int[] count = new int[titleCount];
        for (int i = 0; i < titleCount; i++) {
            count[i] = scanner.nextInt();
        }

        //正误
        int[] tureOrFalse = new int[titleCount];
        for (int i = 0; i < titleCount; i++) {
            tureOrFalse[i] = scanner.nextInt();
        }

        //学生判断
        for (int i = 0; i < studentCount; i++) {
            for (int j = 0; j < titleCount; j++) {
                list[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        int eachCount;
        for (int i = 0; i < studentCount; i++) {
            eachCount = 0;
            for (int j = 0; j < titleCount; j++) {
                if (list[i][j] == tureOrFalse[j]) {
                    eachCount += count[j];
                }
            }
            System.out.println(eachCount);
        }
    }
}
