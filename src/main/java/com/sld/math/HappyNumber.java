package com.sld.math;

/**
 * @author sld
 * leetcode 202
 * https://leetcode.com/problems/happy-number/
 */
public class HappyNumber {

    public static void main(String[] args) {
        int n = 7549;
        System.out.println(isHappy(n));
    }

    private static boolean isHappy(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        if (sum == 1)
            return true;
        if (sum == 4)
            return false;
        return isHappy(sum);
    }
}
