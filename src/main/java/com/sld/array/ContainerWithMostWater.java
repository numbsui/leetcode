package com.sld.array;

/**
 * @author sld
 * <p>
 * leetcode 11
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，
     * 垂直线 i的两个端点分别为(i,ai)和(i, 0).找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
     * <p>
     * 说明：你不能倾斜容器。
     */
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea2(height));
    }

    //方法一：暴力法  两次遍历，计算围成的图形的面积
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
