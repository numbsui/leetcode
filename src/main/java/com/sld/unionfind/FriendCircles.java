package com.sld.unionfind;

/**
 * @author sld
 * <p>
 * leetcode 547
 * https://leetcode.com/problems/friend-circles/
 */
public class FriendCircles {

    public static void main(String[] args) {
        int[][] M = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(findCircleNum(M));
    }

    private static int findCircleNum(int[][] M) {

        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1)
                    uf.union(i, j);
            }
        }
        return uf.count;
    }

    private static class UnionFind {
        int count = 0;
        int[] parent;

        UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
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
