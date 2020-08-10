package com.sld.string;

import java.util.Arrays;
import java.util.List;

/**
 * @author sld
 * <p>
 * leetcode 539
 * https://leetcode.com/problems/minimum-time-difference/
 */
public class MinimumTimeDifference {

    public static void main(String[] args) {
        System.out.println(findMinDifference(Arrays.asList("23:59", "00:00")));
    }

    private static int findMinDifference(List<String> timePoints) {

        if (timePoints.size() > 1440) return 0;
        int[] minutes = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String s = timePoints.get(i);
            minutes[i] = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3));
        }

        Arrays.sort(minutes, 0, minutes.length);

        int result = 1440;
        for (int i = 1; i < minutes.length; i++) {
            result = Math.min(result, minutes[i] - minutes[i - 1]);
            if (result == 0) return 0;
        }
        result = Math.min(result, 1440 - minutes[minutes.length - 1] + minutes[0]);
        return result;
    }
}
