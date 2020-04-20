package com.sld.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sld
 * <p>
 * leetcode 52
 * https://leetcode.com/problems/n-queens-ii/
 */
public class NQueensII {

    private static int result = 0;

    public static void main(String[] args) {
        System.out.println(totalNQueens2(4));
    }

    //方法一：同51题，使用dfs
    private static int totalNQueens(int n) {
        return count(0, new ArrayList<>(), n);
    }

    private static int count(int row, List<Integer> list, int n) {
        if (n == list.size()) return 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (!isValid(list, row, i)) continue;
            list.add(i);
            sum += count(row+1, list, n);
            list.remove(list.size() - 1);
        }
        return sum;
    }

    private static boolean isValid(List<Integer> list, int row, int col) {
        for (int i = 0; i < list.size(); i++) {
            if (col == list.get(i)) return false;
            if (row + col == i + list.get(i)) return false;
            if (row - col == i - list.get(i)) return false;
        }
        return true;
    }

    //方法二：终极解法，使用位运算回溯
    private static int totalNQueens2(int n) {
        if (n < 1) return 0;
        dfs(n, 0, 0, 0, 0);
        return result;
    }

    private static void dfs(int n, int row, int col, int pie, int na) {
        if (row >= n) {
            result++;
            return;
        }

        //得到当前所有的空位
        int bits = (~(col | pie | na)) & ((1 << n) - 1);
        while (bits != 0) {
            //得到最低位的1
            int p = bits & -bits;
            dfs(n, row + 1, col | p, (pie | p) << 1, (na | p) >> 1);
            //去掉最低位的1
            bits = bits & (bits - 1);
        }
    }
}
