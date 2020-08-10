package com.sld.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sld
 * <p>
 * leetcode 228
 * https://leetcode.com/problems/summary-ranges/
 */
public class SummaryRanges {

    public static void main(String[] args) {
        int[] nums = {0, 2, 3, 4, 6, 8, 9, 12};
        System.out.println(summaryRanges(nums));
    }

    private static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null) return result;

        for (int i, count = 0; count < nums.length; count++) {
            i = count;
            while (count < nums.length - 1 && nums[count] + 1 == nums[count + 1])
                count++;
            if (i == count) result.add(nums[i] + "");
            else result.add(nums[i] + "->" + nums[count]);
        }
        return result;
    }
}
