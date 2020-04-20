package com.sld.bitmanipulation;

/**
 * @author sld
 *
 * leetcode 191
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class Numberof1Bits {

    public static void main(String[] args) {
        int n = 0b00000000000000000000000000001011;
        System.out.println(hammingWeight(n));
    }

    private static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count ++;
            n = n & (n - 1);
        }
        return count;
    }
}
