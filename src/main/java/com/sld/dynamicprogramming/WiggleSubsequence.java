package com.sld.dynamicprogramming;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 376
 * https://leetcode.com/problems/wiggle-subsequence/
 */
public class WiggleSubsequence {

    public static void main(String[] args) {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(wiggleMaxLength2(nums));

    }

    //如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。
    // 第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
    //
    //例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。
    // 相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数
    // ，第二个序列是因为它的最后一个差值为零。
    //
    //输入: [1,17,5,10,13,15,10,5,16,8]
    //输出: 7   (1,17,5,10,5,16,8)
    //解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
    //方法一：动态规划
    private static int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length <= 0)
            return 0;
        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = down[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        System.out.println("up:" + Arrays.toString(up));
        System.out.println("down:" + Arrays.toString(down));
        return Math.max(up[n - 1], down[n - 1]);
    }

    //方法二：贪心算法
    private static int wiggleMaxLength2(int[] nums) {
        if (nums.length < 2) return nums.length;
        int preDiff = nums[1] - nums[0];
        int count = preDiff != 0 ? 2 : 1;
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((preDiff <= 0 && diff > 0) || (preDiff >= 0 && diff < 0)) {
                preDiff = diff;
                count++;
            }
        }
        return count;
    }

}
