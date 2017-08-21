import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 测试点3超时
 * Created by q on 17-8-21.
 */
public class P1069 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tranSum = in.nextInt();
        int N = in.nextInt();
        int S = in.nextInt();
        in.nextLine();
        String[] tranPeo = new String[tranSum];
        if (tranSum < N || tranSum < S) {
            System.out.println("Keep going...");
            System.exit(0);
        }
        for (int i = 0; i < tranSum; i++) {
            tranPeo[i] = in.next();
        }
        in.close();
        Set<String> set = new LinkedHashSet<>();
        C:
        for (int i = S - 1; i < tranSum; i = i + N) {
            while (!set.add(tranPeo[i])) {
                for (int j = i + 1; j < tranSum; j++) {
                    while (set.add(tranPeo[j])) {
                        continue C;
                    }
                    if (j == tranSum - 1) {
                        break C;
                    }
                }
            }
        }
        for (String s : set) {
            System.out.println(s);
        }
    }
}
