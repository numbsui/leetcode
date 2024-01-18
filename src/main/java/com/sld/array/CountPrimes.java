package com.sld.array;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 204
 * https://leetcode.com/problems/count-primes/
 */
public class CountPrimes {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(countPrimes(n));
    }

    /**
     * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
     */
    private static int countPrimes(int n) {
        int result = 0;
        int[] primes = new int[n];
        Arrays.fill(primes, 1);

        for (int i = 2; i < n; i++) {
            if (primes[i] == 1)
                result++;

            if ((long) i * i < n) {
                for (int j = i * i; j < n; j += i) {
                    primes[j] = 0;
                }
            }
        }
        return result;
    }

}


