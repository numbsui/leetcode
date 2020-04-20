package com.sld.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author sld
 * <p>
 * leetcode 581
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 */
public class ShortestUnsortedContinuousSubarray {

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray2(nums));
    }

    //方法一：排序，找两个数组最小和最大不同值的位置
    private static int findUnsortedSubarray(int[] nums) {
        int[] oriNums = nums.clone();
        Arrays.sort(nums);
        int start = nums.length;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != oriNums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }

    //方法二：使用栈
    private static int findUnsortedSubarray2(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int min = nums.length;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                min = Math.min(min, stack.pop());
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                max = Math.max(max, stack.pop());
            }
            stack.push(i);
        }
        return (max - min > 0 ? max - min + 1 : 0);
    }
}
