package com.sld.array;

/**
 * @author sld
 * <p>
 * leetcode 45
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGameII {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4, 2, 1};
        System.out.println(jump2(nums));
    }

    //方法一：从后向前遍历，找能到达当前位置的前一个位置的最小值，更新位置 O(n*n)
    private static int jump(int[] nums) {
        int position = nums.length - 1;
        int step = 0;
        while (position != 0) {
            for (int i = 0; i < position; i++) {
                if (nums[i] + i >= position) {
                    position = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }

    //方法二：从前向后遍历，找最大跳跃位置 如2 3 1 1 4，2可以跳3和1，3比1大，所以跳3  O(n)
    private static int jump2(int[] nums) {
        int position = 0;
        int step = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            position = Math.max(position, (nums[i] + i));
            if (i == end) {
                end = position;
                step++;
            }
        }
        return step;
    }
}
