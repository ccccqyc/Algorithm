import java.util.Scanner;

/**
 * 全部超时...
 * Created by q on 17-9-4.
 */
public class P1014 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = new String[4];
        for (int i = 0; i < 4; i++) {
            strings[i] = scanner.next();
        }
        scanner.close();

        int length1 = Math.min(strings[0].length(), strings[1].length());
        char c;
        StringBuilder stringBuilder = new StringBuilder("");
        String s = "";
        int temp = 0;
        int a;
        for (int i = 0; i < length1; i++) {
            c = strings[0].charAt(i);
            if (c >= 65 && c <= 90 && c == strings[1].charAt(i)) {
                temp = i;
                a = c - 64;
                switch (a) {
                    case 1:
                        s = "MON";
                        break;
                    case 2:
                        s = "TUE";
                        break;
                    case 3:
                        s = "WED";
                        break;
                    case 4:
                        s = "THU";
                        break;
                    case 5:
                        s = "FRI";
                        break;
                    case 6:
                        s = "SAT";
                        break;
                    case 7:
                        s = "SUN";
                        break;
                }
                stringBuilder.append(s);
                break;
            }
        }

        stringBuilder.append(" ");

        for (int i = temp + 1; i < length1; i++) {
            c = strings[0].charAt(i);
            if (c == strings[1].charAt(i)) {
                if (c >= 65 && c <= 90) {
                    a = c - 64 + 9;
                    stringBuilder.append(a).append(":");
                    break;
                } else if (c >= 49 && c <= 57) {
                    a = c;
                    stringBuilder.append(a).append(":");
                    break;
                }
            }
        }

        length1 = Math.min(strings[2].length(), strings[3].length());
        for (int i = 0; i < length1; i++) {
            c = strings[2].charAt(i);
            if (c >= 97 && c <= 122 && c == strings[3].charAt(i)) {
                a = i;
                if (a <= 9) {
                    stringBuilder.append("0").append(a);
                } else {
                    stringBuilder.append(a);
                }
            }
        }
        System.out.print(stringBuilder);
    }
}
