package com.sld.bitmanipulation;

/**
 * @author sld
 * <p>
 * leetcode 338
 * https://leetcode.com/problems/counting-bits/
 */
public class CountingBits {

    public static void main(String[] args) {
        int num = 5;
        int[] result = countBits(num);
        for (int i = 0; i <= 5; i++) {
            System.out.println(result[i]);
        }
    }

    //根据通项公式
    private static int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] += result[i & i - 1] + 1;
        }
        return result;
    }
}
