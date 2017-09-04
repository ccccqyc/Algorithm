import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 测试点6 ,7 超时..
 * Created by q on 17-9-3.
 */
public class P1050 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int m = findDivsor(N)[0];
        int n = findDivsor(N)[1];
        int[] ints = new int[N];
        for (int i = 0; i < N; i++) {
            ints[i] = scanner.nextInt();
        }
        scanner.close();
        Arrays.sort(ints);

        int[][] mns = spiralMatrix(m, n, ints);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mns[i][j]);
                if (j != n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static int[] findDivsor(int N) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        for (int i = 2; i <= N; i++) {
            if (N % i == 0) {
                list.add(i);
            }
        }
        int[] mn = new int[2];
        int middle = list.size() / 2;
        c:
        for (int i = middle; i < list.size(); i++) {
            for (int j = middle; j >= 0; j--) {
                if (list.get(i) * list.get(j) == N) {
                    mn[0] = list.get(i);
                    mn[1] = list.get(j);
                    break c;
                }
            }
        }
        return mn;
    }

    //m row
    //n col
    private static int[][] spiralMatrix(int m, int n, int[] sour) {
        int length = sour.length - 1;
        int minCol = 0;
        int minRow = 0;
        int maxCol = n - 1;
        int maxRow = m - 1;
        int[][] ints = new int[m][n];

        while (length >= 0) {
            if (minCol == maxCol) {
                for (int i = minRow; i <=maxRow ; i++) {
                    ints[i][minCol] = sour[length--];
                }
            } else {
                for (int i = minCol; i <= maxCol && maxCol >= 0; i++) {
                    ints[minRow][i] = sour[length--];
                }
                for (int i = minRow + 1; i <= maxRow && maxRow >= 0; i++) {
                    ints[i][maxCol] = sour[length--];
                }
                for (int i = maxCol - 1; i >= minCol && minCol <= n - 1; i--) {
                    ints[maxRow][i] = sour[length--];
                }
                for (int i = maxRow - 1; i >= minRow + 1 && minRow <= m - 1; i--) {
                    ints[i][minCol] = sour[length--];
                }
            }
            minCol++;
            minRow++;
            maxCol--;
            maxRow--;
        }
        return ints;
    }


}

