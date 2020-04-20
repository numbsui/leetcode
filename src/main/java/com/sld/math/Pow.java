package com.sld.math;

/**
 * @author sld
 * <p>
 * leetcode 50
 * https://leetcode.com/problems/powx-n/
 */
public class Pow {

    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2147483648;
        System.out.println(myPow(x, n));
    }

    private static double myPow(double x, int n) {

        if (n == 0) return 1;

        if (n < 0 && n > Integer.MIN_VALUE) {
            return myPow(1 / x, -n);
        }

        if (n % 2 == 1) {
            return x * myPow(x, n - 1);
        } else {
            return myPow(x * x, n / 2);
        }
    }

    private static double myPow2(double x, int n) {

        if (n == 0) return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double result = 1;
        while (n > 0) {
            if ((n & 1) == 1)
                result *= x;
            x *= x;
            n >>= 1;
        }
        return result;

    }
}
