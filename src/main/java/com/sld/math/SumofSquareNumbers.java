package com.sld.math;

/**
 * @author sld
 * leetcode 633
 * https://leetcode.com/problems/sum-of-square-numbers/
 */
public class SumofSquareNumbers {

    public static void main(String[] args) {
        int c = 4;
        System.out.println(judgeSquareSum(c));
    }

    private static boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum < c) {
                left++;
            } else if (sum > c) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }
}
