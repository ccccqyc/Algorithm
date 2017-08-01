import java.util.Scanner;

/**
 * Created by q on 17-8-1.
 */
public class P1021 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String theNum = in.next();
        in.close();

        int num0 = 0;
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;
        int num5 = 0;
        int num6 = 0;
        int num7 = 0;
        int num8 = 0;
        int num9 = 0;

        for (int i = 0; i < theNum.length(); i++) {
            int num = Integer.parseInt(String.valueOf(theNum.charAt(i)));
            switch (num) {
                case 0:
                    num0++;
                    break;
                case 1:
                    num1++;
                    break;
                case 2:
                    num2++;
                    break;
                case 3:
                    num3++;
                    break;
                case 4:
                    num4++;
                    break;
                case 5:
                    num5++;
                    break;
                case 6:
                    num6++;
                    break;
                case 7:
                    num7++;
                    break;
                case 8:
                    num8++;
                    break;
                case 9:
                    num9++;
                    break;
            }
        }
        System.out.println("0:" + num0);
        System.out.println("1:" + num1);
        System.out.println("2:" + num2);
        System.out.println("3:" + num3);
        System.out.println("4:" + num4);
        System.out.println("5:" + num5);
        System.out.println("6:" + num6);
        System.out.println("7:" + num7);
        System.out.println("8:" + num8);
        System.out.println("9:" + num9);

    }
}
