import java.util.Arrays;

/**
 * merge sort
 * Created by q on 17-9-14.
 */
public class Merge_Sort {
    public static void main(String[] args) {
        int[] ints = {1, 3, 4, 5,  8, 0, 6, 9, 7};
        mergeSort(ints);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    private static void mergeSort(int[] a) {
        int length = a.length;
        int start;
        int end;
        int mid;
        for (int i = 1; i < length; i *= 2) {
            for (int j = 0; j < length; j += 2 * i) {
                start = j;
                end = Math.min(j + 2 * i - 1, length - 1);
                mid = (start + end) / 2;
                merge(a, start, mid, end);
            }
        }
    }

    private static void merge(int[] a, int start, int mid, int end) {
        int length = a.length;
        int[] temp = Arrays.copyOf(a, length);
        int i = start;
        int j = mid + 1;
        int k;
        for (k = start; i < mid + 1 && j < end + 1; ) {
            if (temp[i] <= temp[j]) {
                a[k++] = temp[i++];
            } else {
                a[k++] = temp[j++];
            }
        }
        while (i < mid + 1) {
            a[k++] = temp[i++];
        }
        while (j < end + 1) {
            a[k++] = temp[j++];
        }
    }
}
