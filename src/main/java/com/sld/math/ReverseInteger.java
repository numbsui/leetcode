package com.sld.math;

/**
 * @author sld
 * leetcode 7
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverse(Integer.MAX_VALUE));
    }

    private static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            result = result * 10 + pop;
        }
        return result;
    }
}
