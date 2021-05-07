package com.sld.array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author sld
 * <p>
 * leetcode 57
 * https://leetcode.com/problems/insert-interval/
 */
public class InsertInterval {

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }

    /*
    Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
    You may assume that the intervals were initially sorted according to their start times.

    Example 1:
    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
    Output: [[1,5],[6,9]]

    Example 2:
    Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    Output: [[1,2],[3,10],[12,16]]
     */
    private static int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];

        int i = 0;
        int len = intervals.length;
        LinkedList<int[]> result = new LinkedList<>();

        while (i < len && intervals[i][0] < left) {
            result.add(intervals[i++]);
        }

        int[] tmp;
        if (result.isEmpty() || result.getLast()[1] < left) {
            result.add(newInterval);
        } else {
            tmp = result.removeLast();
            tmp[1] = Math.max(tmp[1], right);
            result.add(tmp);
        }

        while (i < len) {
            tmp = intervals[i++];
            int start = tmp[0];
            int end = tmp[1];
            if (result.getLast()[1] < start) {
                result.add(tmp);
            } else {
                tmp = result.removeLast();
                tmp[1] = Math.max(tmp[1], end);
                result.add(tmp);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}


