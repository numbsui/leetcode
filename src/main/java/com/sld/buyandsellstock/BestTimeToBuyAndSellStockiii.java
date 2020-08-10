package com.sld.buyandsellstock;

/**
 * @author sld
 * <p>
 * leetcode 123
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class BestTimeToBuyAndSellStockiii {

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int[][][] profit = new int[prices.length][3][2];
        for (int i = 0; i < prices.length; i++) {
            profit[i][0][0] = 0;
            profit[i][0][1] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < 3; i++) {
            profit[0][i][0] = 0;
            profit[0][i][1] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= 2; j++) {
                profit[i][j][0] = Math.max(profit[i - 1][j][0], profit[i - 1][j][1] + prices[i]);
                profit[i][j][1] = Math.max(profit[i - 1][j][1], profit[i - 1][j - 1][0] - prices[i]);
            }
        }
        return profit[prices.length - 1][2][0];
    }
}
