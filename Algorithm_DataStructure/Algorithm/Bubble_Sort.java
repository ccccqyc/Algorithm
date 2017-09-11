/**
 * Bubble Sort
 * 冒泡排序.
 * Created by q on 17-9-11.
 */

public class Bubble_Sort {
    public static void main(String[] args) {
        int[] ints = {1, 3, 4, 5, 8, 0, 6, 9, 7};
        bubbleSort(ints);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    private static void bubbleSort(int[] ints) {
        int length = ints.length;
        int temp;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                if (ints[j - 1] > ints[j]) {
                    temp = ints[j];
                    ints[j] = ints[j - 1];
                    ints[j - 1] = temp;
                }
            }
        }
    }
}
