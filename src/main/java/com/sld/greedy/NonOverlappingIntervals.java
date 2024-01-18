package com.sld.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sld
 *
 * leetcode 435
 * https://leetcode.com/problems/non-overlapping-intervals/
 */
public class NonOverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };
        System.out.println(eraseOverlapIntervals(intervals));
    }

    private static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1;
        int tmp = intervals[0][1];
        for (int[] arr : intervals) {
            if (arr[0] >= tmp) {
                count++;
                tmp = arr[1];
            }
        }
        return intervals.length - count;
    }
}
