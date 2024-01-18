package com.sld.greedy;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author sld
 * <p>
 * leetcode 860
 * https://leetcode.com/problems/lemonade-change/
 */
public class WalkingRobotSimulation {

    public static void main(String[] args) {
        int[] commands = {4, -1, 4, -2, 4};
        int[][] obstacles = {
                {2, 4},
        };
        System.out.println(robotSim(commands, obstacles));
    }

    private static int robotSim(int[] commands, int[][] obstacles) {
        int[][] ds = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<String> set = Arrays.stream(obstacles).map(new Function<int[], String>() {
            @Override
            public String apply(int[] ints) {
                return ints[0] + " " + ints[1];
            }
        }).collect(Collectors.toSet());

        int x = 0, y = 0, d = 0, result = 0;
        for (int c : commands) {
            if (c == -1) {
                d = (d + 1) % 4;
            } else if (c == -2) {
                d = (d + 3) % 4;
            } else {
                while (c > 0 && !set.contains((x + ds[d][0]) + " " + (y + ds[d][1]))) {
                    x = x + ds[d][0];
                    y = y + ds[d][1];
                    result = Math.max(result, x * x + y * y);
                    c--;
                }
            }
        }

        return result;

    }
}
