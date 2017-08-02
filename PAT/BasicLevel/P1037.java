import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by q on 17-8-1.
 */
public class P1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        bufferedReader.close();

        //note:转义字符
        String[] payS = strings[0].split("\\.");
        String[] giveS = strings[1].split("\\.");

        int[] payI = new int[3];
        int[] giveI = new int[3];
        for (int i = 0; i < 3; i++) {
            payI[i] = Integer.parseInt(payS[i]);
            giveI[i] = Integer.parseInt(giveS[i]);
        }

        int[] save = {0, 0, 0};
        save[2] = giveI[2] - payI[2];
        if (save[2] < 0) {
            save[2] += 29;
            save[1] -= 1;
        }

        save[1] = save[1] + giveI[1] - payI[1];
        if (save[1] < 0) {
            save[1] += 17;
            save[0] -= 1;
        }

        save[0] = save[0] + giveI[0] - payI[0];
        if (save[0] < 0) {
            save[0] += 1;
            //注意此处为16,因save[2]取去1位
            save[1] += -16;
            save[2] += -29;
        }
        System.out.println(save[0] + "." + Math.abs(save[1]) + "." + Math.abs(save[2]));
    }
}
