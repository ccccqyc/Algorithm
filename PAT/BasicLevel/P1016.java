import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class P1016 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        bufferedReader.close();

        int paNum = thePCount(strings[0], strings[1]);
        int pbNum = thePCount(strings[2], strings[3]);

        int pa = the1Num(paNum);
        int pb = the1Num(pbNum);

        System.out.println(pa * Integer.parseInt(strings[1]) + pb * Integer.parseInt(strings[3]));

    }

    private static int thePCount(String s1, String s2) {
        int i = 0;
        for (int j = 0; j < s1.length(); j++) {
            if (s1.charAt(j) == s2.charAt(0)) {
                i++;
            }
        }
        return i;
    }

    private static int the1Num(int n) {
        int num = 0;
        for (int i = 0; i < n; i++) {
            num += Math.pow(10, i);
        }
        return num;
    }
}
