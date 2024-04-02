package com.sld.backtracking;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 60
 * https://leetcode.cn/problems/permutation-sequence/
 */
public class PermutationSequence {

    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        System.out.println(getPermutation(n, k));
    }

    private static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        int[] array = new int[n + 1];
        Arrays.fill(array, 1);

        --k;
        for (int i = 1; i <= n; i++) {
            int num = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; j++) {
                num -= array[j];
                if (num == 0) {
                    sb.append(j);
                    array[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }

        return sb.toString();
    }
}
