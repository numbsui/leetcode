package com.sld.array;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 66
 * https://leetcode.com/problems/plus-one/
 */
public class PlusOne {

    public static void main(String[] args) {
        //int[] digits = {9, 9, 9, 9};
        int[] digits = {9};
        System.out.println(Arrays.toString(plusOne(digits)));


    }

    private static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}


