package com.sld.array;

/**
 * @author sld
 * <p>
 * leetcode 55
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump4(nums));
    }



    //方法一：回溯   超时！！！
    private static boolean canJump(int[] nums) {
        return traversal(0, nums);
    }

    private static boolean traversal(int position, int[] nums) {
        if (position == nums.length - 1) return true;

        int step = Math.min(nums.length - 1, position + nums[position]);
        for (int nextPosition = position + 1; nextPosition <= step; nextPosition++) {
            if (traversal(nextPosition, nums))
                return true;
        }
        return false;
    }

    //方法二：优化上述逻辑，保存计算结果
    private static boolean canJump2(int[] nums) {
        //状态： 0表示初始状态 1表示false 2表示true
        int[] status = new int[nums.length];
        status[nums.length - 1] = 2;
        return traversalSaveStatus(0, nums, status);
    }

    private static boolean traversalSaveStatus(int position, int[] nums, int[] status) {
        if (status[position] != 0) return status[position] == 2;

        int step = Math.min(nums.length - 1, position + nums[position]);
        for (int nextPosition = position + 1; nextPosition <= step; nextPosition++) {
            if (traversalSaveStatus(nextPosition, nums, status)) {
                status[position] = 2;
                return true;
            }
        }
        status[position] = 1;
        return false;
    }

    //方法三：贪心算法 3, 2, 1, 0, 4      12345
    private static boolean canJump3(int[] nums) {
        int end = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if ((i + nums[i] >= end)) {
                end = i;
            }
        }
        return end == 0;
    }

    //方法四：如果某一个作为起跳点的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为起跳点。
    //      可以对每一个能作为起跳点的格子都尝试跳一次，把能跳到最远的距离不断更新。如果可以一直跳到最后，就成功了
    private static boolean canJump4(int[] nums) {
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > step) return false;
            step = Math.max(step, (i + nums[i]));
            if (step > nums.length) break;
        }
        return true;
    }
}
