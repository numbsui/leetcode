package com.sld.math;

/**
 * @author sld
 * <p>
 * leetcode 69
 * https://leetcode.com/problems/sqrtx/
 */
public class Sqrt {

    public static void main(String[] args) {
        int x = 8;
        System.out.println(mySqrt2(x));
    }

    //方法一：使用二分查找
    private static int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int l = 1;
        int r = x;
        int result = 0;

        while (l <= r) {
            int m = (l + r) / 2;
            if (m == x / m) {
                return m;
            } else if (m > x / m) {
                r = m - 1;
            } else {
                l = m + 1;
                result = m;
            }
        }
        return result;
    }

    //方法二：根据牛顿迭代法，找通项公式
    private static int mySqrt2(int x) {
        if (x == 0 || x == 1) return x;
        int y = x;
        while (y * y > x) {
            y = (y + x / y) / 2;
        }
        return y;
    }
}
