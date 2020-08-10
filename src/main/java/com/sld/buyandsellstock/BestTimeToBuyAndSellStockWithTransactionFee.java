package com.sld.buyandsellstock;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 714
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
    }

    private static int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;
        int[][] profit = new int[prices.length][2];
        profit[0][0] = 0;
        profit[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit[i][0] = Math.max(profit[i - 1][0], profit[i - 1][1] + prices[i] - fee);
            profit[i][1] = Math.max(profit[i - 1][1], profit[i - 1][0] - prices[i]);
        }
        System.out.println(Arrays.deepToString(profit));
        return profit[prices.length - 1][0];
    }
}
