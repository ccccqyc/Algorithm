import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 链表
 *
 * @author charQ
 */
public class A1097 {

    final static int MAXN = 100000;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Node[] nodes = new Node[MAXN];
        StringTokenizer stringTokenizer = null;
        try {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        int firsrtaddress = Integer.parseInt(stringTokenizer.nextToken()); // nodes 和 nodes1中第一个节点地址
        int count = Integer.parseInt(stringTokenizer.nextToken());

        int cnt1 = 0, cnt2 = 0, address;
        int[] arrint = new int[10001];
        Arrays.fill(arrint, 0);
        Arrays.fill(nodes,new Node());
        for (int i = 0; i < count; i++) {
            try {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                address = Integer.parseInt(stringTokenizer.nextToken());
                nodes[address].key = Integer.parseInt(stringTokenizer.nextToken());
                nodes[address].nextaddress = Integer.parseInt(stringTokenizer.nextToken());
                nodes[address].address = address;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (int i = firsrtaddress; i != -1; i = nodes[i].nextaddress) {
            if (arrint[Math.abs(nodes[i].key)] == 1) {
                nodes[i].num = MAXN + cnt2;
                cnt2++;
            } else {
                nodes[i].num = cnt1;
                cnt1++;
                arrint[Math.abs(nodes[i].key)] = 1;
            }
        }
//        Arrays.sort(nodes, (o1, o2) -> o1.num - o2.num);
        Arrays.sort(nodes, Comparator.comparingInt(o -> o.num));

        int cnt = cnt1 + cnt2;
        for (int i = 0; i < cnt; i++) {
            if (i != cnt - 1 && 1 != cnt1 - 1) {
                System.out.printf("%05d %d %05d\n", nodes[i].address, nodes[i].key, nodes[i + 1].address);
            } else {
                System.out.printf("%05d %d -1\n", nodes[i].address, nodes[i].key);
            }
        }
        System.out.println(" dd ");
    }


    /**
     * // 0-99999 restore
     * // 100000-19999 delete
     * // 200000 invalid
     */
    static class Node {
        int address;
        int key;
        int nextaddress;
        int num = 200000;
    }

}
