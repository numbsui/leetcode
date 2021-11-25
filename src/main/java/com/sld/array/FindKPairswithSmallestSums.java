package com.sld.array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author sld
 * <p>
 * leetcode 373
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 */
public class FindKPairswithSmallestSums {

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {1, 2, 3};
        int k = 2;
        System.out.println(kSmallestPairs(nums1, nums2, k));
    }

    private static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(k, (o1, o2) ->
                (o2.get(0) + o2.get(1)) - (o1.get(0) + o1.get(1)));

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                List<Integer> list = new ArrayList<>();
                if (priorityQueue.size() < k) {
                    list.add(nums1[i]);
                    list.add(nums2[j]);
                    priorityQueue.add(list);
                } else {
                    if (priorityQueue.peek().get(0) + priorityQueue.peek().get(1) > nums1[i] + nums2[j]) {
                        priorityQueue.poll();
                        list.add(nums1[i]);
                        list.add(nums2[j]);
                        priorityQueue.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(priorityQueue);
    }

}
