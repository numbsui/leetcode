package com.sld.math;

/**
 * @author sld
 * leetcode 9
 * https://leetcode.com/problems/reverse-integer/
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome2(0));
    }

    private static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int origin = x;
        int result = 0;
        int pop;
        while (x != 0) {
            pop = x % 10;
            x = x / 10;
            result = result * 10 + pop;
        }
        return origin == result;
    }

    private static boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x > 0)) return false;
        int result = 0;
        while (x > result) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。

        return x == result || x == result / 10;
    }
}
