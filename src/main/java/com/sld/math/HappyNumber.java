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

    /**
     * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
     * 如果可以变为1，那么这个数就是快乐数。
     *
     * 输入：19
     * 输出：true
     * 解释：
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     */
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
