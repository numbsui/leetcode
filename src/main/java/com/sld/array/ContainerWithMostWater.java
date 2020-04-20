package com.sld.array;

/**
 * @author sld
 * <p>
 * leetcode 11
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea2(height));
    }

    //方法一：暴力法
    private static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int res = (Math.min(height[i], height[j])) * (j - i);
                if (res > max)
                    max = res;
            }
        }
        return max;
    }

    //方法二：双指针法
    private static int maxArea2(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while (l != r) {
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
