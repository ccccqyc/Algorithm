import java.util.Scanner;

/**
 * 测试点4 超时.
 * Created by q on 17-8-16.
 */
public class P1058 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int studentsCount = in.nextInt();
        int titleCount = in.nextInt();
        in.nextLine();
        String[][] titleDescribe = new String[titleCount][3];
        for (int i = 0; i < titleCount; i++) {
            titleDescribe[i][0] = String.valueOf(in.nextInt());
            titleDescribe[i][1] = String.valueOf(in.nextInt());
            titleDescribe[i][2] = in.nextLine().trim();
        }

        String[][] studentSolution = new String[studentsCount][titleCount];
        String[] temp;
        for (int i = 0; i < studentsCount; i++) {
            temp = in.nextLine().split("\\) \\(");
            for (int j = 0; j < titleCount; j++) {
                studentSolution[i][j] =
                        temp[j].replace(")", "").replace("(", "");
            }
        }

        int[][] students = new int[studentsCount][1 + titleCount];
        int[] titles = new int[titleCount];
        int maxNum = 0;

        for (int i = 0; i < studentsCount; i++) {
            for (int j = 1; j < 1 + titleCount; j++) {
                if (titleDescribe[j - 1][2].equals(studentSolution[i][j - 1])) {
                    students[i][0] += Integer.parseInt(titleDescribe[j - 1][0]);
                    students[i][j] = 1;
                } else {
                    titles[j - 1]++;
                    if (maxNum < titles[j - 1]) {
                        maxNum = titles[j - 1];
                    }
                }
            }
            System.out.println(students[i][0]);
        }

        StringBuilder stringBuilder = new StringBuilder(maxNum + " ");
        for (int i = 0; i < titleCount; i++) {
            if (maxNum == titles[i]) {
                stringBuilder.append(i).append(1).append(" ");
            }
        }

        if (maxNum == 0) {
            System.out.println("Too simple");
        } else {
            System.out.print(stringBuilder.toString().trim());
        }
    }
}