import java.util.Arrays;
import java.util.Scanner;

/**
 * binary search tree
 * 用到BST的特性
 * 1.以输出顺序保存结点,结点坐标为i,左节点坐标2<up>i</up>,右结点2<up>i</up>+1
 * 2.根结点坐标0.
 * 如第二层即根结点的子节点在数组中顺序分别是2^0,2^0+1.
 *
 * java基本上告别了PAT,慢....
 * 测试全部超时.
 * Created by q on 17-9-18.
 */
public class A1064 {
    private static int k = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        int[] ints = new int[count];
        int[] intsPrint = new int[count];
        for (int i = 0; i < count; i++) {
            ints[i] = scanner.nextInt();
        }
        scanner.close();
        Arrays.sort(ints);

        tian(0, ints, intsPrint);

        for (int i = 0; i < count; i++) {
            System.out.print(intsPrint[i]);
            if (i != count - 1) {
                System.out.print(" ");
            }
        }
    }
    private static void tian(int root, int[] ints, int[] intPrint) {
        int length = ints.length;
        if (root > length - 1) {
            return;
        }
        tian(2 * root + 1, ints, intPrint);
        intPrint[root] = ints[k++];
        tian(2 * root + 2, ints, intPrint);
    }
}