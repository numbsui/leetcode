package com.sld.array;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 75
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColors {

    public static void main(String[] args) {
        //int[] nums = {2, 0, 2, 1, 1, 0};
        int[] nums = {1, 2, 0};
        sortColors3(nums);
        System.out.println(Arrays.toString(nums));
    }

    //方法一：遍历两次，每次交换0和1的位置
    private static void sortColors(int[] nums) {
        int head = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int tmp = nums[head];
                nums[head] = nums[i];
                nums[i] = tmp;
                head++;
            }
        }

        for (int i = head; i < nums.length; i++) {
            if (nums[i] == 1) {
                int tmp = nums[head];
                nums[head] = nums[i];
                nums[i] = tmp;
                head++;
            }
        }
    }

    //方法二：双指针，两个指针记录0和1的位置，遍历到1时直接交换，遍历到0时，需判断p0是否小于p1，
    //       如果小于，则需交换当前位置和指针p1的位置
    private static void sortColors2(int[] nums) {
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int tmp = nums[p1];
                nums[p1] = nums[i];
                nums[i] = tmp;
                p1++;
            }
            if (nums[i] == 0) {
                int tmp = nums[p0];
                nums[p0] = nums[i];
                nums[i] = tmp;
                if (p0 < p1) {
                    tmp = nums[p1];
                    nums[p1] = nums[i];
                    nums[i] = tmp;
                }
                p0++;
                p1++;
            }
        }
    }


    //方法三：双指针，两个指针记录0和2的位置，p0指向头，p1指向尾，遍历到0时直接交换，遍历到2时，
    //       需要不断地将其与nums[p1] 进行交换，直到新的nums[i] 不为 2
    private static void sortColors3(int[] nums) { //1 2 0  1 0 2
        int p0 = 0;
        int p1 = nums.length - 1;
        for (int i = 0; i <= p1; i++) {
            while (i <= p1 && nums[i] == 2) {
                int tmp = nums[p1];
                nums[p1] = nums[i];
                nums[i] = tmp;
                p1--;
            }
            if (nums[i] == 0) {
                int tmp = nums[p0];
                nums[p0] = nums[i];
                nums[i] = tmp;
                p0++;
            }
        }
    }
}
