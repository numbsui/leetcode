package com.sld.bfs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sld
 * <p>
 * leetcode 1162
 * 相关 102 1162 103 104 199 515 637
 * https://leetcode.cn/problems/as-far-from-land-as-possible/
 */
public class AsFarFromLandAsPossible {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}};
        System.out.println(maxDistance(grid));
    }

    //从每个1出发，依次循环每个1周围4个点，如果没有越界，并且是0，则加入队列，并且记录为已访问。
    private static int maxDistance(int[][] grid) {
        int length = grid.length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        if (queue.isEmpty() || queue.size() == length * length) {
            return -1;
        }

        int[][] moves = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        int result = -1;
        while (!queue.isEmpty()) {
            result++;
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                int[] poll = queue.poll();
                int r = poll[0];
                int c = poll[1];
                for (int[] move : moves) {
                    int r1 = r + move[0];
                    int c1 = c + move[1];
                    if (inArea(r1, c1, grid) && grid[r1][c1] == 0) {
                        grid[r1][c1] = 2;
                        queue.add(new int[]{r1, c1});
                    }
                }
            }
        }
        return result;
    }

    private static boolean inArea(int r, int c, int[][] grid) {
        return (r >= 0 && r < grid.length) && (c >= 0 && c < grid.length);
    }
}
