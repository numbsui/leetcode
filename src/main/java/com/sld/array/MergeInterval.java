package com.sld.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author sld
 * <p>
 * leetcode 56
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeInterval {

    public static void main(String[] args) {
        //int[][] intervals = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));

    }

    /**
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * <p>
     * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
     */
    private static int[][] merge(int[][] intervals) {

        if (intervals.length <= 1)
            return intervals;

        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[] tmp = intervals[0];
        result.add(tmp);
        for (int[] interval : intervals) {
            if (interval[0] <= tmp[1]) {
                tmp[1] = Math.max(interval[1], tmp[1]);
            } else {
                tmp = interval;
                result.add(interval);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}


