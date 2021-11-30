package com.sld.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sld
 * <p>
 * leetcode 15
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     */
    public static void main(String[] args) {
        //int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-4, -1, -1, -1, 0, 1, 2, 2};
        System.out.println(threeSum(nums));
    }

    //-4 -1 -1 0 1 2
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        //先排序（从小到大）
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //从左到右遍历，下一个数等于前一个数，则直接跳过
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //如果当前的值大于0，则退出循环（数组从小到大排序，当前值大于0，结果一定大于0）
            if (nums[i] > 0) break;
            //定义双指针  左指针指向i的下一个 右指针指向末尾
            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                int sum = nums[i] + nums[head] + nums[tail];
                if (sum == 0) {
                    //结果等于0，则加到返回列表
                    result.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                    //如果左指针下一个的值与当前相等，则去重
                    while (head < tail && nums[head] == nums[head + 1]) head++;
                    //如果右指针前一个的值与当前相等，则去重
                    while (head < tail && nums[tail] == nums[tail - 1]) tail--;
                    head++;
                    tail--;
                } else if (sum < 0) {
                    head++;
                } else {
                    tail--;
                }
            }
        }
        return result;
    }
}
