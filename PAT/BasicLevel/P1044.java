import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * all pass.
 * Created by q on 17-8-31.
 */
public class P1044 {
    public static void main(String[] args) throws IOException {
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(0, "tret");
        map1.put(1, "jan");
        map1.put(2, "feb");
        map1.put(3, "mar");
        map1.put(4, "apr");
        map1.put(5, "may");
        map1.put(6, "jun");
        map1.put(7, "jly");
        map1.put(8, "aug");
        map1.put(9, "sep");
        map1.put(10, "oct");
        map1.put(11, "nov");
        map1.put(12, "dec");
        Map<Integer, String> map2 = new HashMap<>();
        map2.put(1, "tam");
        map2.put(2, "hel");
        map2.put(3, "maa");
        map2.put(4, "huh");
        map2.put(5, "tou");
        map2.put(6, "kes");
        map2.put(7, "hei");
        map2.put(8, "elo");
        map2.put(9, "syy");
        map2.put(10, "lok");
        map2.put(11, "mer");
        map2.put(12, "jou");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        scanner.nextLine();
        String[] strings = new String[length];
        for (int i = 0; i < length; i++) {
            strings[i] = scanner.nextLine();
            if (isNum(strings[i])) {
                strings[i] = numToString(strings[i], map1, map2);
            } else {
                strings[i] = stringToNum(strings[i], map1, map2);
            }
        }
        scanner.close();
        for (int i = 0; i < length; i++) {
            System.out.println(strings[i]);
        }
    }

    private static boolean isNum(String s) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(s).matches();
    }

    private static String numToString(String s, Map map1, Map map2) {
        int quotient = Integer.parseInt(s) / 13;
        int residue = Integer.parseInt(s) % 13;
        StringBuilder stringBuilder = new StringBuilder("");
        if (quotient > 0) {
            //noinspection LoopStatementThatDoesntLoop
            while (map2.containsKey(quotient)) {
                stringBuilder.append(map2.get(quotient));
                break;
            }
            if (residue != 0) {
                stringBuilder.append(" ");
            }
        }

        while (map1.containsKey(residue)) {
            if (residue != 0) {
                stringBuilder.append(map1.get(residue));
            }
            break;
        }
        if (quotient == 0 && residue == 0) {
            stringBuilder.append(map1.get(0));
        }
        return stringBuilder.toString();
    }

    private static String stringToNum(String s, Map map1, Map map2) {
        String[] string2 = s.split(" ");
        int length = string2.length;
        int key = 0;
        if (string2.length == 2 || map2.containsValue(string2[0])) {
            for (int i = 1; i <= map2.size(); i++) {
                if (map2.get(i).equals(string2[0])) {
                    key += i * 13;
                    break;
                }
            }
        }
        for (int i = 0; i < map1.size(); i++) {
            if (map1.get(i).equals(string2[length - 1])) {
                key += i;
                break;
            }
        }
        return String.valueOf(key);
    }
}
