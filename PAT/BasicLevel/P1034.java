import java.util.Scanner;

/**
 * 测试点2 错误..
 *
 * Created by q on 17-9-7.
 */
public class P1034 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        scanner.close();
        String string1 = simplest(strings[0]);
        String string2 = simplest(strings[1]);

        String[] ss = {" + ", " - ", " * ", " / "};
        for (String s : ss) {
            if (s.equals(" / ") && strings[1].charAt(0) == '0') {
                System.out.println(string1 + s + string2 + " = " + "Inf");
            } else {
                System.out.println(string1 + s + string2 + " = " + simplest(compute(strings[0], strings[1], s)));
            }
        }
    }

    private static String compute(String string1, String string2, String sign) {
        String[] string1s = string1.split("/");
        String[] string2s = string2.split("/");
        long[] longs1 = {Long.parseLong(string1s[0]), Long.parseLong(string1s[1])};
        long[] longs2 = {Long.parseLong(string2s[0]), Long.parseLong(string2s[1])};

        String returnString = "";
        switch (sign) {
            case " + ":
                returnString = String.valueOf(longs1[0] * longs2[1] + longs2[0] * longs1[1]) + "/" + String.valueOf(longs1[1] * longs2[1]);
                break;
            case " - ":
                returnString = String.valueOf(longs1[0] * longs2[1] - longs2[0] * longs1[1]) + "/" + String.valueOf(longs1[1] * longs2[1]);
                break;
            case " * ":
                returnString = String.valueOf(longs1[0] * longs2[0]) + "/" + String.valueOf(longs1[1] * longs2[1]);
                break;
            case " / ":
                if (longs2[0] < 0) {
                    longs2[1] = -longs2[1];
                }
                returnString = String.valueOf(longs1[0] * longs2[1]) + "/" + String.valueOf(Math.abs(longs1[1] * longs2[0]));
                break;
        }
        return returnString;

    }

    private static String simplest(String string) {
        String[] strings = string.split("/");
        long[] longs = {Long.parseLong(strings[0]), Long.parseLong(strings[1])};
        StringBuilder stringBuilder = new StringBuilder("");
        if (longs[0] < 0) {
            stringBuilder.append("(-");
            longs[0] = -longs[0];
        }
        long divisor = longs[0] / longs[1];
        long redisu = longs[0] % longs[1];
        if (divisor != 0) {
            stringBuilder.append(divisor);
        }
        if (redisu != 0) {
            if (divisor != 0) {
                stringBuilder.append(" ");
            }
            long gcd = gcd(redisu, longs[1]);
            stringBuilder.append(redisu / gcd + "/" + longs[1] / gcd);
        }
        if (Integer.parseInt(strings[0]) < 0) {
            stringBuilder.append(")");
        }
        if (divisor == 0 && redisu == 0) {
            stringBuilder.append("0");
        }
        return stringBuilder.toString();
    }

    //最大公约数
    private static long gcd(long m, long n) {
        while (n != 0) {
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }
}
