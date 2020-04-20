package com.sld.buyandsellstock;

/**
 * @author sld
 * <p>
 * leetcode 122
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeToBuyAndSellStockii {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit2(prices));
    }

    private static int maxProfit(int[] prices) {
        int count = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                count = count + (prices[i] - prices[i - 1]);
            }
        }
        return count;
    }

    //不限制买卖次数,这时可以去掉状态方程中的k（定义看121题）。
    private static int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[][] profit = new int[prices.length][2];
        profit[0][0] = 0;
        profit[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit[i][0] = Math.max(profit[i - 1][0], profit[i - 1][1] + prices[i]);
            profit[i][1] = Math.max(profit[i - 1][1], profit[i - 1][0] - prices[i]);
        }
        return profit[prices.length - 1][0];
    }

}
