package com.sld.dynamicprogramming;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 42
 * https://leetcode.cn/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        //int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height = {2, 1, 0, 1, 2};
        System.out.println(trap(height));
    }

    private static int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        System.out.println(Arrays.toString(maxLeft));

        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        System.out.println(Arrays.toString(maxRight));

        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i])
                sum += min - height[i];
        }
        return sum;
    }
}
