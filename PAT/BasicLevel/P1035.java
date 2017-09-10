import java.util.Arrays;
import java.util.Scanner;

/**
 * 测试点2,5,6错误...
 * 常看常新
 * insertSort
 * mergeSort
 * Created by q on 17-9-2.
 */
public class P1035 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        scanner.nextLine();
        long[] longSour = new long[length];
        long[] longSort = new long[length];
        for (int i = 0; i < length; i++) {
            longSour[i] = scanner.nextLong();
        }
        scanner.nextLine();
        for (int i = 0; i < length; i++) {
            longSort[i] = scanner.nextLong();
        }
        scanner.close();
        long[] temp = Arrays.copyOf(longSour, length);

        if (insert(longSour, longSort)) {
            System.out.print("Insertion Sort\n" + longSour[0]);
            for (int i = 1; i < length; i++) {
                System.out.print(" " + longSour[i]);
            }
        }
        if (mergeSort(temp, longSort)) {
            System.out.print("Merge Sort\n" + temp[0]);
            for (int i = 1; i < length; i++) {
                System.out.print(" " + temp[i]);
            }
        }

    }

    private static boolean insert(long[] sour, long[] sorted) {
        int length = sour.length;
        long temp;

        //ifContinue = true the 1st-for-loop continue.
        boolean ifContinue = true;
        for (int i = 1; i < length; i++) {
            if (!ifContinue) {
                break;
            }
            if (isSame(sour, sorted)) {
                ifContinue = false;
            }
            for (int j = i; j > 0; j--) {
                if (sour[j] < sour[j - 1]) {
                    temp = sour[j - 1];
                    sour[j - 1] = sour[j];
                    sour[j] = temp;
                } else {
                    break;
                }
            }
        }
        return !ifContinue;
    }

    private static boolean mergeSort(long[] sour, long[] sorted) {
        int length = sour.length;


        //ifContinue = true the 1st-for-loop continue.
        boolean isContinue = true;
        int start;
        int mid;
        int end;

        for (int i = 1; i < length; i *= 2) {
            if (!isContinue) {
                break;
            }
            if (isSame(sour, sorted)) {
                isContinue = false;
            }
            for (int j = 0; j < length; j += 2 * i) {
                //start, mid ,end 0开始
                start = j;
                end = Math.min(j + 2 * i - 1, length - 1);
                mid = (end + start) / 2;
                merge(sour, start, mid, end);
            }
        }
        return !isContinue;
    }

    private static void merge(long[] arr, int start, int mid, int end) {

        int i = start;
        int j = mid + 1;
        int k;
        long[] temp = Arrays.copyOf(arr, arr.length);
        for (k = start; i < 1 + mid && j < end + 1; ) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }
        while (i < 1 + mid) {
            arr[k++] = temp[i++];
        }
        while (j < end + 1) {
            arr[k++] = temp[j++];
        }
    }

    //arr1 == arr2 return true;
    private static boolean isSame(long[] arr1, long[] arr2) {
        boolean b = true;
        if (arr1.length != arr2.length) {
            return false;
        }
        int length = arr1.length;
        for (int i = 0; i < length; i++) {
            if (arr1[i] != arr2[i]) {
                b = false;
                break;
            }
        }
        return b;
    }
}
