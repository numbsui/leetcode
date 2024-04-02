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
        //int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals = {{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
        System.out.println(Arrays.deepToString(merge2(intervals)));

    }

    private static int[][] merge2(int[][] intervals) {
        if (intervals.length < 2) return intervals;
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(value -> value[0]));
        int[] tmp = intervals[0];
        result.add(tmp);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= tmp[1]) {
                int[] ints = result.get(result.size() - 1);
                if (interval[1] >= tmp[1]) {
                    ints[1] = interval[1];
                }
            } else {
                result.add(interval);
                tmp = interval;
            }
        }
        return result.toArray(new int[0][]);
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


