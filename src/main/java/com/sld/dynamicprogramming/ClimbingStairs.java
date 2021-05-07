package com.sld.dynamicprogramming;

/**
 * @author sld
 * <p>
 * leetcode 70
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(climbStairs(n));
    }

    private static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] array = new int[n];
        array[0] = 1;
        array[1] = 2;
        for (int i = 2; i < n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n - 1];
    }
}
