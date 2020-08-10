package com.sld.buyandsellstock;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 309
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        //初始值
        int[][] profit = new int[prices.length][3];
        profit[0][0] = -prices[0];

        //0 持有  1 不持有，冷冻期  2 不持有，不在冷冻期
        for (int i = 1; i < prices.length; i++) {
            profit[i][0] = Math.max(profit[i - 1][0], profit[i - 1][2] - prices[i]);
            profit[i][1] = profit[i - 1][0] + prices[i];
            profit[i][2] = Math.max(profit[i - 1][1], profit[i - 1][2]);
        }

        return Math.max(profit[prices.length - 1][1], profit[prices.length - 1][2]);
    }
}
