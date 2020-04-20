package com.sld.heap;

import java.util.*;

/**
 * @author sld
 * <p>
 * leetcode 703
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
public class KthLargestElementInAStream {

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4, 5, 8, 2};

        KthLargest2 kthLargest = new KthLargest2(3, arr);
        System.out.println(kthLargest.add(3));   // returns 4
        System.out.println(kthLargest.add(5));   // returns 5
        System.out.println(kthLargest.add(10));  // returns 5
        System.out.println(kthLargest.add(9));   // returns 8
        System.out.println(kthLargest.add(4));   // returns 8

    }

    //将前k大数据保存起来，新来数据进行比较
    static class KthLargest {

        int[] largeKNumbers;

        public KthLargest(int k, int[] nums) {
            if (k > nums.length) {
                k = nums.length;
            }
            largeKNumbers = new int[k];
            Arrays.sort(nums);

            for (int i = 0; i < k; i++) {
                largeKNumbers[i] = nums[nums.length + i - k];
            }
        }

        public int add(int val) {
            if (val <= largeKNumbers[0]) {
                return largeKNumbers[0];
            } else {
                largeKNumbers[0] = val;
                Arrays.sort(largeKNumbers);
                return largeKNumbers[0];
            }
        }
    }

    //使用优先队列PriorityQueue
    static class KthLargest2 {

        PriorityQueue<Integer> heap;
        int kNum;

        public KthLargest2(int k, int[] nums) {
            heap = new PriorityQueue<>(k);
            kNum = k;
            for (Integer num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            heap.offer(val);
            if(heap.size() > kNum) {
                heap.poll();
            }

            return heap.peek();
        }
    }
}
