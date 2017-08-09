import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by q on 17-8-9.
 */
public class P1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = in.readLine().toLowerCase().toCharArray();
        in.close();

        List<Character> list = new ArrayList<>();
        for (char c : chars) {
            if (c >= 97 && c <= 122) {
                list.add(c);
            }
        }

        Iterator<Character> iterator = list.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            sum += ((int) iterator.next() - 96);
        }
        int zeroCount = 0;
        int oneCount = 0;
//        String[] binaryInts = Integer.toBinaryString(sum).split("");
//        for (String s : binaryInts) {
//            if (s.equals("0")) {
//                zeroCount++;
//            } else {
//                oneCount++;
//            }
//        }

        while(sum!=0){
            if (sum%2!=0){
                oneCount++;
            }else {
                zeroCount++
            ;}
            sum /=2;
        }
        System.out.print(zeroCount + " " + oneCount);
    }
}
