import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * all pass.
 * Created by q on 17-8-23.
 */
public class P1005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            ints[i] = scanner.nextInt();
        }
        scanner.close();

        List<Integer> listNum = new LinkedList<>();
        List<List<Integer>> listArr = new LinkedList<>();
        listArr.add(getList(ints[0]));
        listNum.add(ints[0]);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < listArr.size(); j++) {
                if (isInIt(listArr.get(j), ints[i])) {
                    break;
                } else if (isInIt(getList(ints[i]), listNum.get(j))) {
                    listNum.remove(j);
                    listNum.add(ints[i]);
                    listArr.remove(j);
                    listArr.add(getList(ints[i]));
                } else if (j == listNum.size() - 1) {
                    listNum.add(ints[i]);
                    listArr.add(getList(ints[i]));

                }
            }
        }

        Collections.sort(listNum);
        for (int i = listNum.size() - 1; i >= 0; i--) {
            System.out.print(listNum.get(i));
            if (i != 0) {
                System.out.print(" ");
            }
        }
    }

    private static List<Integer> getList(int m) {
        List<Integer> list = new LinkedList<>();
        while (m != 1) {
            list.add(m);
            if (m % 2 == 0) {
                m = m / 2;
            } else {
                m = (3 * m + 1) / 2;
            }
        }
        list.add(1);
        return list;
    }

    private static boolean isInIt(List<Integer> list, int i) {
        boolean b = false;
        for (int i1 : list) {
            if (i1 == i) {
                b = true;
                break;
            }
        }
        return b;
    }
}
