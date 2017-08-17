import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by q on 17-8-16.
 */
public class P1058 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int students = in.nextInt();
        int title = in.nextInt();
        in.nextLine();
        String[][] titleDescribe = new String[title][];
        for (int i = 0; i < title; i++) {
            titleDescribe[i] = in.nextLine().split(" ");
        }
        String[][] studentSolution = new String[title][ ];
        List<String[][]> list = new ArrayList<>();
        int length;
        String s1 = "";


        for (int i = 0; i < students; i++) {
            length = in.skip("(\\()").nextInt();
            for (int j = 0; j < title; j++) {
                for (int k = 0; k < length; k++) {
                    studentSolution[j][k] = in.next().toString();
                }
            }
            list.add(studentSolution);
        }

        for (String[][] s : list) {
            for (String[] s2 : s) {
                for(String s3:s2){
                    System.out.print(s3 + " ");
                }
            }
            System.out.println();
        }

    }
}