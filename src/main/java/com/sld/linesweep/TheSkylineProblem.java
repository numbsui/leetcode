package com.sld.linesweep;

import java.util.*;

/**
 * @author sld
 * <p>
 * leetcode 218
 * https://leetcode.com/problems/the-skyline-problem/
 */
public class TheSkylineProblem {

    public static void main(String[] args) {
        //int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        int[][] buildings = {{2, 11, 5}, {3, 9, 10}};
        System.out.println(getSkyline(buildings));
    }


    /**
     * Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
     * Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
     * Explanation:
     * Figure A shows the buildings of the input.
     * Figure B shows the skyline formed by those buildings.
     * The red points in figure B represent the key points in the output list.
     *
     * @param buildings
     * @return
     */
    private static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);

        for (int[] building : buildings) {
            priorityQueue.offer(new int[]{building[0], -building[2]});
            priorityQueue.offer(new int[]{building[1], building[2]});
        }

        TreeMap<Integer, Integer> heights = new TreeMap<>((a, b) -> b - a);
        heights.put(0, 1);
        int left = 0;
        int height = 0;
        while (!priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            if (poll[1] < 0) {
                heights.put(-poll[1], heights.getOrDefault(-poll[1], 0) + 1);
            } else {
                heights.put(poll[1], heights.get(poll[1]) - 1);
                if (heights.get(poll[1]) == 0) heights.remove(poll[1]);
            }

            int maxHeight = heights.keySet().iterator().next();
            if (maxHeight != height) {
                left = poll[0];
                height = maxHeight;
                result.add(Arrays.asList(left, height));
            }
        }

        return result;
    }
}


/*
class Solution {
  /**
   *  Divide-and-conquer algorithm to solve skyline problem,
   *  which is similar with the merge sort algorithm.
   *
public List<List<Integer>> getSkyline(int[][] buildings) {
    int n = buildings.length;
    List<List<Integer>> output = new ArrayList<List<Integer>>();

    // The base cases
    if (n == 0) return output;
    if (n == 1) {
        int xStart = buildings[0][0];
        int xEnd = buildings[0][1];
        int y = buildings[0][2];

        output.add(new ArrayList<Integer>() {{add(xStart); add(y); }});
        output.add(new ArrayList<Integer>() {{add(xEnd); add(0); }});
        // output.add(new int[]{xStart, y});
        // output.add(new int[]{xEnd, 0});
        return output;
    }

    // If there is more than one building,
    // recursively divide the input into two subproblems.
    List<List<Integer>> leftSkyline, rightSkyline;
    leftSkyline = getSkyline(Arrays.copyOfRange(buildings, 0, n / 2));
    rightSkyline = getSkyline(Arrays.copyOfRange(buildings, n / 2, n));

    // Merge the results of subproblem together.
    return mergeSkylines(leftSkyline, rightSkyline);
}

    /**
     *  Merge two skylines together.
     *
    public List<List<Integer>> mergeSkylines(List<List<Integer>> left, List<List<Integer>> right) {
        int nL = left.size(), nR = right.size();
        int pL = 0, pR = 0;
        int currY = 0, leftY = 0, rightY = 0;
        int x, maxY;
        List<List<Integer>> output = new ArrayList<List<Integer>>();

        // while we're in the region where both skylines are present
        while ((pL < nL) && (pR < nR)) {
            List<Integer> pointL = left.get(pL);
            List<Integer> pointR = right.get(pR);
            // pick up the smallest x
            if (pointL.get(0) < pointR.get(0)) {
                x = pointL.get(0);
                leftY = pointL.get(1);
                pL++;
            }
            else {
                x = pointR.get(0);
                rightY = pointR.get(1);
                pR++;
            }
            // max height (i.e. y) between both skylines
            maxY = Math.max(leftY, rightY);
            // update output if there is a skyline change
            if (currY != maxY) {
                updateOutput(output, x, maxY);
                currY = maxY;
            }
        }

        // there is only left skyline
        appendSkyline(output, left, pL, nL, currY);

        // there is only right skyline
        appendSkyline(output, right, pR, nR, currY);

        return output;
    }

    /**
     * Update the final output with the new element.
     *
    public void updateOutput(List<List<Integer>> output, int x, int y) {
        // if skyline change is not vertical -
        // add the new point
        if (output.isEmpty() || output.get(output.size() - 1).get(0) != x)
            output.add(new ArrayList<Integer>() {{add(x); add(y); }});
            // if skyline change is vertical -
            // update the last point
        else {
            output.get(output.size() - 1).set(1, y);
        }
    }

    /**
     *  Append the rest of the skyline elements with indice (p, n)
     *  to the final output.

    public void appendSkyline(List<List<Integer>> output, List<List<Integer>> skyline,
                              int p, int n, int currY) {
        while (p < n) {
            List<Integer> point = skyline.get(p);
            int x = point.get(0);
            int y = point.get(1);
            p++;

            // update output
            // if there is a skyline change
            if (currY != y) {
                updateOutput(output, x, y);
                currY = y;
            }
        }
    }
}

 */