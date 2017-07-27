package best_time_to_buy_stock;

/**
 * 3
 * Say you have an array for which the i-th element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 *
 * 实际上是求波浪线的所有上升段的长度和。
 * Created by q on 17-7-23.
 */
public class Two {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        int length = prices.length;
        if (length == 0)
            return 0;

        int result = 0;

        int buy = prices[0];
        int last = prices[0];

        for (int i = 0; i < length; i++) {
            if (prices[i] < last) {
                result += (last - buy);
                buy = prices[i];
            }
            last = prices[i];
        }
        result += (last - buy);
        return result;

    }
}
