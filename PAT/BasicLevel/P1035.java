import java.util.Scanner;

/**
 * insertSort
 * mergeSort
 * Created by q on 17-9-2.
 */
public class P1035 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        scanner.nextLine();
        int[] intSour = new int[length];
        int[] intSort = new int[length];
        for (int i = 0; i < length; i++) {
            intSour[i] = scanner.nextInt();
        }
        scanner.nextLine();
        insert(intSour);
        for (int i = 0; i < length; i++) {
            intSort[i] = scanner.nextInt();
            System.out.print(intSour[i] + " ");
        }
        scanner.close();
    }

    private static int[] insert(int[] sour) {
        int length = sour.length;
        int temp;
        for (int i = 1; i < length; i++) {
            for (int j = i; j >0; j--) {
                if (sour[j]<sour[j-1]) {
                    temp = sour[j-1];
                    sour[j-1] = sour[j];
                    sour[j] = temp;
                } else {
                    break;
                }
            }
        }
        return sour;
    }

    public static int[] merge(int[] sour) {
        return new int[sour.length];
    }
}
