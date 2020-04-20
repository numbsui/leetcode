package com.sld.heap;

import java.util.*;

/**
 * @author sld
 * <p>
 * leetcode 239
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {1, 3, -1, 0, -2, 3, 6, 7};

        int[] result = maxSlidingWindow2(arr, k);
        for (Integer i : result)
            System.out.println(i);
    }

    //使用大顶堆保存窗口，滑动时维护堆
    private static int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                priorityQueue.offer(nums[i]);
                if (i == k - 1) {
                    result[0] = priorityQueue.peek();
                }
            } else {
                priorityQueue.remove(nums[i - k]);
                priorityQueue.offer(nums[i]);
                result[i - k + 1] = priorityQueue.peek();
            }
        }
        return result;
    }

    //使用双端队列，滑动时在队列保存下标，同时判断是否越界，是否新值小于老值
    private static int[] maxSlidingWindow2(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }

        return result;
    }
}
