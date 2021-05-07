package com.sld.array;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author sld
 * <p>
 * leetcode 414
 * https://leetcode.com/problems/third-maximum-number/
 */
public class ThirdMaximumNumber {

    public static void main(String[] args) {
        int[] num = {2, 2, 3, 1};
        System.out.println(thirdMax(num));
    }

    private static int thirdMax(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        for (int i : set) {
            if (priorityQueue.size() == 3) {
                priorityQueue.poll();
            }
            priorityQueue.offer(i);
        }

        if (priorityQueue.size() < 3) {
            while (priorityQueue.size() > 1)
                priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
}
