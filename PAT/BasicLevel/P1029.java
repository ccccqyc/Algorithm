import java.util.*;

/**
 * Created by q on 17-8-7.
 */
public class P1029 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] c1 = in.nextLine().toCharArray();
        char[] c2 = in.nextLine().toCharArray();

        Set<Character> s1 = new LinkedHashSet<>();
        Set<Character> s2 = new LinkedHashSet<>();

        for (char aC1 : c1) {
            s1.add(Character.toUpperCase(aC1));
        }
        for (Character c : c2) {
            s2.add(Character.toUpperCase(c));
        }

        Iterator it1 = s1.iterator();

        char test;
        Set<Character> s3 = new LinkedHashSet<>();

        while(it1.hasNext()){
            test = (Character) it1.next();
            if(!s2.contains(test)&&!s3.contains(Character.toUpperCase(test))){
                s3.add(Character.toUpperCase(test));
            }
        }

        for (Object aS3 : s3) {
            System.out.print(aS3);
        }
    }
}
