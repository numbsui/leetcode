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


