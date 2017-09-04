import java.util.Arrays;
import java.util.Scanner;

/**
 * 测试点3,4超时.
 *
 * Created by q on 17-9-4.
 */
public class P1065 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cp = scanner.nextInt();
        String[][] cpStrings = new String[cp][2];
        scanner.nextLine();
        for (int i = 0; i < cp; i++) {
            cpStrings[i] = scanner.nextLine().split(" ");
        }
        int pp = scanner.nextInt();
        scanner.nextLine();
        String[] ppStrings = scanner.nextLine().split(" ");
        scanner.close();
        int[] ints;

        for (int j = 0; j < cp; j++) {
            ints = contain(ppStrings, cpStrings[j]);
            if (ints[2] == 2) {
                ppStrings[ints[0]] = "";
                ppStrings[ints[1]] = "";
            }
        }

        int count = 0;
        StringBuilder stringBuilder = new StringBuilder("");
        Arrays.sort(ppStrings);
        for (int i = 0; i < pp; i++) {
            if (!ppStrings[i].equals("")) {
                count++;
                stringBuilder = stringBuilder.append(ppStrings[i]).append(" ");
            }
        }

        System.out.println(count);
        System.out.print(stringBuilder.toString().trim());

    }

    private static int[] contain(String[] strings, String[] strings2) {
        int[] index = new int[3];
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < strings.length; i++) {
                if (strings[i].equals(strings2[j])) {
                    index[2]++;
                    index[j] = i;
                    break;
                }
            }
        }
        return index;
    }
}
