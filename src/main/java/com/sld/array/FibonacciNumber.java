package com.sld.array;

/**
 * @author sld
 * <p>
 * leetcode 509
 * https://leetcode.com/problems/fibonacci-number/
 */
public class FibonacciNumber {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(fib(n));

    }

    private static int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int x = 0;
        int y = 1;
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result = (x + y);
            x = y;
            y = result;
        }
        return result;
    }
}


