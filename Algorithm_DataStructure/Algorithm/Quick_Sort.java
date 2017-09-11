/**
 * Quick Sort
 * 快速排序.
 * O(nlog<sup>n</sup>)
 * Created by q on 17-9-11.
 */
public class Quick_Sort {
    public static void main(String[] args) {
        int[] ints = {1, 3, 4, 5, 8, 0, 6, 2, 9, 7};
        quickSort(ints);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    private static void quickSort(int[] ints) {
        //初始传入r == arr.length
        quickSort(ints, 0, ints.length - 1);
    }

    private static void quickSort(int[] ints, int l, int r) {
        int i = l;
        int j = r;
        int x = ints[l];
        while (i < j) {
            while (x <= ints[j]) {
                j--;
            }
            //可能j-- == i;下同
            if (i < j) {
                ints[i++] = ints[j];
            }
            while (i < j && x > ints[i]) {
                i++;
            }
            if (i < j) {
                ints[j--] = ints[i];
            }
            ints[i] = x;
            quickSort(ints, l, i - 1);
            quickSort(ints, i + 1, r);
        }
    }
}
