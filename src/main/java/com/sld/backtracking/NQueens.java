package com.sld.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sld
 * <p>
 * leetcode 51
 * https://leetcode.com/problems/n-queens/
 */
public class NQueens {

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    private static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        helper(n, result, new ArrayList<>(), 0);
        return result;
    }

    private static void helper(int n, List<List<String>> result, List<Integer> list, int row) {
        if (list.size() == n) {
            List<String> board = new ArrayList<>();
            for (int num : list) {
                char[] outCharArray = new char[n];
                Arrays.fill(outCharArray, '.');
                outCharArray[num] = 'Q';
                board.add(String.valueOf(outCharArray));
            }
            result.add(board);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isValid(list, row, i)) continue;
            list.add(i);
            helper(n, result, list, row + 1);
            list.remove(list.size() - 1);
        }
    }

    private static boolean isValid(List<Integer> list, int row, int col) {
        for (int i = 0; i < list.size(); i++) {
            if (col == list.get(i)) return false;
            if (row + col == i + list.get(i)) return false;
            if (row - col == i - list.get(i)) return false;
        }
        return true;
    }
}
