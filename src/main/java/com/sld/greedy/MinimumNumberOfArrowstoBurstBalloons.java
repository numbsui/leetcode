package com.sld.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sld
 * <p>
 * leetcode 452
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class MinimumNumberOfArrowstoBurstBalloons {

    public static void main(String[] args) {
        int[][] points = {
                {10, 16},
                {2, 8},
                {1, 6},
                {7, 12}
        };
        System.out.println(findMinArrowShots(points));
    }

    private static int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int count = 1;
        int tmp = points[0][1];
        for (int[] arr : points) {
            if (arr[0] > tmp) {
                count++;
                tmp = arr[1];
            }
        }
        return count;
    }

}
