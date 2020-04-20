package com.sld.array;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 621
 * https://leetcode.com/problems/task-scheduler/
 */
public class TaskScheduler {

    public static void main(String[] args) {
        //char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        char[] tasks = {'A', 'B', 'C', 'D', 'E', 'E'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }

    private static int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for (char c : tasks)
            arr[c - 'A']++;
        Arrays.sort(arr);
        int result = 0;
        while (arr[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (arr[25] == 0)
                    break;
                if (i < 26 && arr[25 - i] > 0) {
                    arr[25 - i]--;
                }
                result++;
                i++;
            }
            Arrays.sort(arr);
        }
        return result;
    }
}
