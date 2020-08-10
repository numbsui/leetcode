package com.sld.buyandsellstock;

/**
 * @author sld
 * <p>
 * leetcode 188
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class BestTimeToBuyAndSellStockiv {

    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        int k = 2;
        System.out.println(maxProfit(k, prices));
    }


    private static int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        if (k >= prices.length / 2) {
            int count = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    count = count + (prices[i] - prices[i - 1]);
                }
            }
            return count;
        }

        int[][][] profit = new int[prices.length][k + 1][2];
        for (int i = 0; i < prices.length; i++) {
            profit[i][0][0] = 0;
            profit[i][0][1] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < k + 1; i++) {
            profit[0][i][0] = 0;
            profit[0][i][1] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                profit[i][j][0] = Math.max(profit[i - 1][j][0], profit[i - 1][j][1] + prices[i]);
                profit[i][j][1] = Math.max(profit[i - 1][j][1], profit[i - 1][j - 1][0] - prices[i]);
            }
        }
        return profit[prices.length - 1][k][0];
    }
}
