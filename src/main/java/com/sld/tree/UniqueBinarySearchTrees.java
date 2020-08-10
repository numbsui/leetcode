package com.sld.tree;

/**
 * @author sld
 * <p>
 * leetcode 96
 * https://leetcode.com/problems/unique-binary-search-trees/
 */
public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(numTrees(n));
    }

    //1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862,
    //16796, 58786, 208012, 742900, 2674440, 9694845, 35357670, 129644790,
    //477638700, 1767263190, 6564120420, 24466267020, 91482563640,
    //343059613650, 1289904147324, 4861946401452
    //卡塔兰数
    private static int numTrees(int n) {
        int[] nums = new int[n + 1];
        nums[0] = nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                nums[i] += nums[j] * nums[i - j - 1];
            }
        }
        return nums[n];
    }
}
