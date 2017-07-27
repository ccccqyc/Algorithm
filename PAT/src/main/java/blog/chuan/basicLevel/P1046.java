package blog.chuan.basicLevel;

import java.util.Scanner;

public class P1046 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();

        int A = 0;
        int B = 0;
        for (int i = 0; i < count; i++) {
            int Ahan = in.nextInt();
            int Ahua = in.nextInt();
            int Bhan = in.nextInt();
            int Bhua = in.nextInt();

            int sum = Ahan + Bhan;
            if (sum == Ahua && sum != Bhua) {
                A++;
            } else if (sum != Ahua && sum == Bhua) {
                B++;
            }
        }

        in.close();
        System.out.println(A + " " + B);
    }
}
