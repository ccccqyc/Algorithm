import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by q on 17-8-10.
 */
public class P1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int cout = Integer.parseInt(bufferedReader.readLine());
        String[][] strings = new String[cout][3];
        strings[0] = bufferedReader.readLine().split(" ");
        String[] min = strings[0];
        String[] max = strings[0];
        for (int i = 1; i < cout; i++) {
            strings[i] = bufferedReader.readLine().split(" ");
            if (Integer.parseInt(strings[i][2])>Integer.parseInt(max[2])){
                max=strings[i];
            }else if(Integer.parseInt(strings[i][2])<Integer.parseInt(min[2])){
                min=strings[i];
            }
        }
        bufferedReader.close();
        System.out.println(max[0]+" "+max[1]);
        System.out.println(min[0]+" "+min[1]);
    }
}
