import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by q on 17-8-3.
 */
public class P1064 {
    public static void main(String[] args) throws IOException,NullPointerException {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        in.nextLine();
        String[] strings = in.nextLine().split(" ");
        in.close();

        int friends = 0;
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < strings[i].length(); j++) {
                friends += Integer.parseInt(String.valueOf(strings[i].charAt(j)));
            }
            set.add(friends);
            friends = 0;
        }
        System.out.println(set.size());

        Object[] ints = set.toArray();
        StringBuilder s = null;
        for (int i = 0; i < ints.length; i++) {
            if (i != ints.length - 1) {
                s.append(ints[i]).append(" ");
            } else {
                s.append(ints[i]);
            }
        }
        System.out.println(s);
    }
}
