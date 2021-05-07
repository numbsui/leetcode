package com.sld.array;

/**
 * @author sld
 * <p>
 * leetcode 268
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber2(nums));
    }

    /**
     * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
     * <p>
     * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
     * <p>
     * Example 1:
     * Input: nums = [3,0,1]
     * Output: 2
     * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
     * 2 is the missing number in the range since it does not appear in nums.
     * <p>
     * <p>
     * Example 2:
     * Input: nums = [0,1]
     * Output: 2
     * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2].
     * 2 is the missing number in the range since it does not appear in nums.
     * <p>
     * <p>
     * Example 3:
     * Input: nums = [9,6,4,2,3,5,7,0,1]
     * Output: 8
     * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9].
     * 8 is the missing number in the range since it does not appear in nums.
     *
     * @param nums
     * @return
     */
    private static int missingNumber(int[] nums) {
        //相同的数异或结果是0   0和缺少的数异或，结果就是缺少的数
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            n ^= i ^ nums[i];
        }
        return n;
    }

    private static int missingNumber2(int[] nums) {

        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return n * (n + 1) / 2 - sum;
    }


    /**
     * 扩展：找出缺失的两个数
     * <p>
     * x平方+y平方=（x+y）的平方-2xy
     *
     * @param nums
     * @return
     */
    private static int missingNumber3(int[] nums) {

        int n = nums.length;
        int sum = 0;
        int sum2 = 0;
        for (int num : nums) {
            sum += num;
            sum2 += num * num;
        }

        int sumxy = n * (n + 1) / 2 - sum;
        int sumxy2 = 0;

        for (int i = 1; i <= n; i++) {
            sumxy2 += i * i;
        }

        int xmy = sumxy * sumxy - (sumxy2 - sum2);
        int subxy = (int) Math.sqrt(sumxy * sumxy - 2 * xmy);

        System.out.println((sumxy + subxy) / 2);
        System.out.println((sumxy - subxy) / 2);


        return 0;
    }
}
