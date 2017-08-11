import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by q on 17-8-10.
 */
public class P1008 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        String[] strings;
        int M = in.nextInt();
        in.nextLine();
        strings = in.nextLine().split(" ");
        in.close();

        String[] subStrings = Arrays.copyOfRange(strings, length - M, length);
        System.arraycopy(strings, 0, strings, M, length - M - 1 + 1);

        for (int i = 0; i < length; i++) {
            if (i<M){
                System.out.print(subStrings[i]);
            }else if(i>=M){
                System.out.print(strings[i]);
            }
            if (i!=length-1){
                System.out.print(" ");
            }
        }

    }
}
