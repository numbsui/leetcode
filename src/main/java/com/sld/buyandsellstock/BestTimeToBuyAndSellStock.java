package com.sld.buyandsellstock;

/**
 * @author sld
 * <p>
 * leetcode 121
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 *
 * 121 122 123 309 188 714 股票系列问题，统一可以用动态规划解决。
 *
 * 121 122 123 188解题思路：
 * 寻找状态方程，可定义为mp[i][j]  i(0,n) j(0,1),0表示当前没有持有股票，1表示当前持有股票
 *      则： mp[i][0] = Max( mp[i-1][0], mp[i-1][1]+a[i] )
 *          mp[i][1] = Max( mp[i-1][1], mp[i-1][0]-a[i] )
 *
 * 对于上述状态方程，可以发现，并没有记录买卖次数的状态，因此需要在上述方程基础上，增加一个纬度，
 * 此时可以定义为mp[i][k][j]  i(0,n) j(0,1),0表示当前没有持有股票，1表示当前持有股票  k表示买卖次数
 *      则： mp[i][k][0] = Max( mp[i-1][k][0], mp[i-1][k-1][1]+a[i] )
 *          mp[i][k][1] = Max( mp[i-1][k][1], mp[i-1][k-1][0]-a[i] )
 * 最后的结果为：Max( mp[n-1][0...k][0] )
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    //只买卖一次 方法一：定义DP方程
    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int result = 0;
        //第二维表示买卖次数，这里是2，所以是0-2，第三维是否持有可以不用定义（因为
        // 只买卖一次，那么最后肯定是把股票卖出，要不然血亏。）
        int[][] profit = new int[prices.length][3];
        profit[0][0] = 0;
        profit[0][1] = -prices[0];
        profit[0][2] = 0;

        for (int i = 1; i < prices.length; i++) {
            profit[i][0] = profit[i - 1][0];
            profit[i][1] = Math.max(profit[i - 1][1], profit[i - 1][0] - prices[i]);
            profit[i][2] = Math.max(profit[i][0], profit[i - 1][1] + prices[i]);
            result = Math.max(result, Math.max(profit[i][2], profit[i][1]));
        }

        return result;
    }

    //方法二：遍历求最大值
    private static int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int price = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < price) {
                price = prices[i];
            } else {
                int profilt = prices[i] - price;
                result = Math.max(result, profilt);
            }
        }
        return result;
    }
}
