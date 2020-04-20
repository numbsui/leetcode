package com.sld.backtracking;

/**
 * @author sld
 * <p>
 * leetcode 79
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        //String word = "ABCCED";
        //String word = "SEE";
        String word = "ABCB";
        System.out.println(board.length);
        System.out.println(board[0].length);
        System.out.println(exist(board, word));
    }

    //解法：深度优先遍历
    private static boolean exist(char[][] board, String word) {
        //多少行
        int row = board.length;
        //多少列
        int col = board[0].length;
        if (row == 0 || col == 0) return false;

        //代表当前位置的上 左 右 下
        int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        boolean[][] state = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(i, j, 0, board, word, state, direction)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int i, int j, int start, char[][] board, String word, boolean[][] state, int[][] direction) {
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }

        if (board[i][j] == word.charAt(start)) {
            state[i][j] = true;
            for (int[] ints : direction) {
                int newX = i + ints[0];
                int newY = j + ints[1];
                if (inArea(newX, newY, board) && !state[newX][newY]) {
                    if (dfs(newX, newY, start + 1, board, word, state, direction)) {
                        return true;
                    }
                }
            }
            state[i][j] = false;
        }
        return false;
    }

    private static boolean inArea(int x, int y, char[][] board) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
}
