import java.util.Scanner;

/**
 * 全部超时...
 * 我要转投C++.!!
 * Created by q on 17-9-3.
 */
public class P1020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int kinds = scanner.nextInt();
        int requirement = scanner.nextInt();
        scanner.nextLine();
        //总量
        int[] gross = new int[kinds];
        //总售价
        int[] prices = new int[kinds];
        //单价
        float[] price = new float[kinds];
        for (int i = 0; i < kinds; i++) {
            gross[i] = scanner.nextInt();
        }
        for (int i = 0; i < kinds; i++) {
            prices[i] = scanner.nextInt();
            price[i] = (float) prices[i] / gross[i];
        }
        scanner.close();

        //收益
        float income = 0;
        //最高价货物售价
        float etMax;
        //最高价货物index
        int etIndex;
        while (requirement != 0) {
            etMax = findMax(price)[0];
            etIndex = (int) findMax(price)[1];
            if (gross[etIndex] < requirement) {
                income += prices[etIndex];
                requirement -= gross[etIndex];
            } else {
                income += etMax * requirement;
                requirement = 0;
            }
            price[etIndex] = 0;
        }

        System.out.printf("%.2f", income);
    }

    private static float[] findMax(float[] floats) {
        float[] temp = new float[2];
        for (int i = 0; i < floats.length; i++) {
            if (temp[0] < floats[i]) {
                temp[0] = floats[i];
                temp[1] = i;
            }
        }
        return temp;
    }
}
