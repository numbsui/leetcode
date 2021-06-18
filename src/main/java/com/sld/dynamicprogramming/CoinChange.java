package com.sld.dynamicprogramming;

/**
 * @author sld
 * <p>
 * leetcode 322
 * https://leetcode.com/problems/coin-change/
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {2, 5, 1};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    //dp[n] = min{dp[n], dp[n-coin]+1}
    //dp[1] = min{dp[1], dp[0]+1}
    //dp[2] = min{dp[2], dp[0]+1} min{dp[2], dp[1]+1}
    private static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    //dp方程
                    System.out.println("i:" + i);
                    System.out.println("coin:" + coin);
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    System.out.println("dp[i]:" + dp[i]);
                    System.out.println();
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
