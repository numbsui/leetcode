package com.sld.array;

import java.util.*;

/**
 * @author sld
 * <p>
 * leetcode 373
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 */
public class IncreasingSubsequences {

    private static Stack<Integer> stack = new Stack<>();

    private static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        System.out.println(findSubsequences2(nums));
    }

    //[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]
    //
    private static List<List<Integer>> findSubsequences2(int[] nums) {
        List<Integer> list = new ArrayList<>();

        func2(nums, -1, list);
        return result;
    }

    private static void func2(int[] nums, int idx, List<Integer> curList) {
        // 只要当前的递增序列长度大于 1，就加入到结果 res 中，然后继续搜索递增序列的下一个值。
        if (curList.size() > 1) {
            result.add(new ArrayList<>(curList));
        }

        // 在 [idx + 1, nums.length - 1] 范围内遍历搜索递增序列的下一个值。
        // 借助 set 对 [idx + 1, nums.length - 1] 范围内的数去重。
        Set<Integer> set = new HashSet<>();
        for (int i = idx + 1; i < nums.length; i++) {
            // 1. 如果 set 中已经有与 nums[i] 相同的值了，说明加上 nums[i] 后的所有可能的递增序列之前已经被搜过一遍了，因此停止继续搜索。
            if (set.contains(nums[i])) {
                System.out.println("set:" +set);
                System.out.println("cur:" + nums[i]);
                System.out.println("----------");
                continue;
            }
            set.add(nums[i]);
            // 2. 如果 nums[i] >= nums[idx] 的话，说明出现了新的递增序列，因此继续 dfs 搜索（因为 curList 在这里是复用的，因此别忘了 remove 哦）
            if (idx == -1 || nums[i] >= nums[idx]) {
                curList.add(nums[i]);
                func2(nums, i, curList);
                curList.remove(curList.size() - 1);
            }
        }
    }

    //[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]
    //
    private static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        func(0, nums, result);
        return result;
    }

    //46 467 4677
    private static void func(int cur, int[] nums, List<List<Integer>> result) {
        if (cur == nums.length) {
            return;
        }

        for (int i = cur; i < nums.length; i++) {
            if (stack.size() > 0) {
                if (nums[cur] >= stack.peek()) {
                    stack.push(nums[cur]);
                }
            } else {
                stack.push(nums[cur]);
            }

            if (stack.size() > 1 && !result.contains(new ArrayList<>(stack))) {
                result.add(new ArrayList<>(stack));
            }

            func(cur + 1, nums, result);
            stack.pop();
        }
    }
}
