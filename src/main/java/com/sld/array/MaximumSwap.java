package com.sld.array;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 670
 * https://leetcode.com/problems/maximum-swap/
 */
public class MaximumSwap {

    public static void main(String[] args) {
        int num = 9937;
        System.out.println(maximumSwap(num));
    }

    //2736
    private static int maximumSwap(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        int[] arrs = new int[10];
        for (int i = 0; i < chars.length; i++) {
            arrs[chars[i] - '0'] = i;
        }
        System.out.println(Arrays.toString(arrs));

        for (int i = 0; i < chars.length; i++) {
            for (int d = 9; d > chars[i] - '0'; d--) {
                if (arrs[d] > i) {
                    char tmp = chars[i];
                    chars[i] = chars[arrs[d]];
                    chars[arrs[d]] = tmp;
                    return Integer.parseInt(new String(chars));
                }
            }
        }
        return num;
    }
}
