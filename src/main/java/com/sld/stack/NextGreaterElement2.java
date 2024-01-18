package com.sld.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author sld
 * <p>
 * leetcode 503
 * https://leetcode.com/problems/next-greater-element-ii/
 */
public class NextGreaterElement2 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    private static int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * length - 1; i++) {
            while (!stack.isEmpty() && nums[i % length] > nums[stack.peek()]) {
                result[stack.pop()] = nums[i % length];
            }
            stack.push(i % length);
        }
        return result;
    }
}


