import java.util.Scanner;

/**
 * Created by q on 17-8-21.
 */
public class P1011 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int teamNum = in.nextInt();
        in.nextLine();
        String[][] team = new String[teamNum][];
        for (int i = 0; i < teamNum; i++) {
            team[i] = in.nextLine().split(" ");
            System.out.println("Case #" + (i + 1) + ": " +
                    (
                            (Long.parseLong(team[i][0]) + Long.parseLong(team[i][1]))
                                    > Long.parseLong(team[i][2]) ? "true" : "false"
                    ));
        }
        in.close();
    }
}
