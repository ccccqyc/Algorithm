import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 我要投奔C++了....
 * Java也太慢了..
 * Created by q on 17-9-4.
 */
public class P1045 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] ints = new int[length];
        scanner.nextLine();
        for (int i = 0; i < length; i++) {
            ints[i] = scanner.nextInt();
        }
        scanner.close();

        boolean b = true;
        //使用Set防止相同数字,重复添加进入list
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (ints[j] > ints[i]) {
                    b = false;
                }
            }
            for (int j = i; j < length; j++) {
                if (ints[j] < ints[i]) {
                    b = false;
                }
            }
            if (b) {
                list.add(ints[i]);
            } else {
                b = true;
            }
        }

        //不支持排序
        Object[] o = list.toArray();
        int size = list.size();
        System.out.println(size);
        Arrays.sort(o);
        for (int i = 0; i < size; i++) {
            System.out.print(o[i]);
            if (i != size - 1) {
                System.out.print(" ");
            }
        }

    }
}
