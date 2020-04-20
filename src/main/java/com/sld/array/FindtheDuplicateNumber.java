package com.sld.array;

import java.util.*;

/**
 * @author sld
 * <p>
 * leetcode 287
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class FindtheDuplicateNumber {

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2, 3};
        System.out.println(findDuplicate3(nums));
    }

    //方法一：集合
    private static int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }
        return -1;
    }

    //方法二：排序
    private static int findDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    //方法三：快慢指针
    private static int findDuplicate3(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int ptr1 = nums[0];
        int ptr2 = slow;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }
}
