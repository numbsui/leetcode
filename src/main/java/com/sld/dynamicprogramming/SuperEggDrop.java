package com.sld.dynamicprogramming;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 887
 * https://leetcode.com/problems/super-egg-drop/
 */
public class SuperEggDrop {

    private static int count = 0;

    public static void main(String[] args) {
        int K = 6;
        int N = 10000;
        System.out.println(superEggDrop(K, N));
    }

    private static int superEggDrop(int K, int N) {
        int[][] memo = new int[K + 1][N + 1];

        int result = dp(K, N, memo);
        System.out.println("memo:" + Arrays.deepToString(memo));
        System.out.println("count:" + count);
        return result;
    }

    private static int dp(int k, int n, int[][] memo) {
        count++;
        if (memo[k][n] > 0) return memo[k][n];

        if (n == 0) return 0;

        if (k == 1) return n;

        int result = n;
        int l = 1;
        int r = n;
        while (l < r) {
            int mid = (l + r)/2;
            int left = dp(k - 1, mid - 1, memo);
            int right = dp(k, n - mid, memo);
            result = Math.min(result, Math.max(left, right) + 1);

            if (left == right) break;
            else if (left < right) l = mid + 1;
            else r = mid;
        }

        memo[k][n] = result;
        return result;
    }
}
