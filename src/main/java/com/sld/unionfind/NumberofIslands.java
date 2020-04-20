package com.sld.unionfind;

/**
 * @author sld
 * <p>
 * leetcode 200
 * https://leetcode.com/problems/number-of-islands/
 */
public class NumberofIslands {

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static boolean[][] visited;
    private static char[][] g;

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands2(grid));
    }

    //方法一：DFS染色，深度优先遍历，碰到1时，将1的 上 下 左 右 替换为0
    private static int numIslands(char[][] grid) {

        if (grid.length == 0) return 0;
        visited = new boolean[grid.length][grid[0].length];
        g = grid;

        int result = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                result += floodfill_dfs(i, j);
            }
        }
        return result;
    }

    private static int floodfill_dfs(int x, int y) {
        if (x < 0 || x >= g.length || y < 0 || y >= g[0].length || g[x][y] == '0' || visited[x][y]) return 0;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            floodfill_dfs(x + dx[i], y + dy[i]);
        }
        return 1;
    }


    //方法二：并查集，将同一个岛内的点指向同一个根节点
    private static int numIslands2(char[][] grid) {
        if (grid.length == 0) return 0;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int x1 = i + dx[k];
                    int y1 = j + dy[k];
                    if (x1 >= 0 && y1 >= 0 && x1 < grid.length && y1 < grid[0].length && grid[x1][y1] == '1')
                        uf.union(i * grid[0].length + j, x1 * grid[0].length + y1);
                }
            }
        }
        return uf.count;
    }

    private static class UnionFind {
        int count = 0;
        int m;
        int n;
        int[] parent;

        UnionFind(char[][] grid) {
            m = grid.length;
            n = grid[0].length;
            parent = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        count++;
                    }
                }
            }
        }

        private void union(int node1, int node2) {
            int x1 = find(node1);
            int x2 = find(node2);
            if (x1 != x2) {
                parent[x1] = x2;
                count--;
            }
        }

        private int find(int node) {
            if (parent[node] != node)
                parent[node] = find(parent[node]);
            return parent[node];
        }
    }

}
