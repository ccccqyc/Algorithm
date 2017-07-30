import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by q on 17-7-29.
 */
public class P1041 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<Integer, int[]> map = new HashMap<>();
        int sNum = in.nextInt();
        int testNum = 0;
        int firstSeat = 0;
        int lastSeat = 0;
        int[] seat = {testNum,lastSeat};
        for (int i = 0; i < sNum; i++) {
            testNum = in.nextInt();
            firstSeat = in.nextInt();
            lastSeat  = in.nextInt();
            map.put(firstSeat,seat);
        }

        for (int i = 0; i <in.nextInt() ; i++) {
            System.out.println(map.get(in.nextInt()));
        }

    }
}
