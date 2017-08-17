import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by q on 17-8-15.
 */
public class P1055 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int peopleNum = in.nextInt();
        int row = in.nextInt();
        in.nextLine();
        String[][] people = new String[peopleNum][2];
        int[] heigh = new int[peopleNum];
        for (int i = 0; i < peopleNum; i++) {
            people[i] = in.nextLine().split(" ");
            heigh[i] = Integer.parseInt(people[i][1]);
        }
        in.close();

        int rowPeoNum = peopleNum / row;
        Arrays.sort(heigh);
        int[] subRowPeoNum = Arrays.copyOfRange(heigh, (row-1)*rowPeoNum, heigh.length);

        List<int[]> list = new ArrayList<>();
        for (int i = (row-1)*rowPeoNum-1; i > 0; i -= rowPeoNum) {
            list.add(subRowPeoNum);
            subRowPeoNum = Arrays.copyOfRange(heigh,  i - rowPeoNum,i);
        }
        list.add(subRowPeoNum);



    }
}
