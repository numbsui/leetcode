package com.sld.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sld
 * <p>
 * leetcode 84
 * https://leetcode.cn/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }

    private static int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int length = heights.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int result = 0;
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();

        for (int i = length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right[i] = length;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        for (int i = 0; i < length; i++) {
            result = Math.max(result, (right[i] - left[i] - 1) * heights[i]);
        }
        return result;
    }
}


