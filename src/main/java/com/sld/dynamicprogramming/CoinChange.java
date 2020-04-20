package com.sld.dynamicprogramming;

/**
 * @author sld
 * <p>
 * leetcode 322
 * https://leetcode.com/problems/coin-change/
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        System.out.println(coinChange(coins, amount));
    }

    private static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    //dp方程
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
