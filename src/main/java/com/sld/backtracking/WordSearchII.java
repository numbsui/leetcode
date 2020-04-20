package com.sld.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sld
 * <p>
 * leetcode 212
 * https://leetcode.com/problems/word-search-ii/
 */
public class WordSearchII {

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        String[] words = {"oath","pea","eat","rain", "race"};
        System.out.println(findWords(board, words));
    }

    private static List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        List<String> list = new ArrayList<>();
        for (String word : words) {
            trie.insert(word);
        }

        int row = board.length;
        if (row == 0) return list;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(board, i, j, trie.root, list);
            }
        }

        return list;
    }

    private static void dfs(char[][] board, int row, int col, TrieNode node, List<String> list) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;

        char cur = board[row][col];
        if (cur == '*' || node.children[cur - 'a'] == null) return;

        node = node.children[cur - 'a'];
        if (node.word != null) {
            list.add(node.word);
            node.word = null;
        }

        char tmp = board[row][col];
        board[row][col] = '*';
        dfs(board, row - 1, col, node, list); //上
        dfs(board, row + 1, col, node, list); //下
        dfs(board, row, col - 1, node, list); //左
        dfs(board, row, col + 1, node, list); //右
        board[row][col] = tmp;
    }
}

class TrieNode {
    public TrieNode[] children;
    public String word;

    public TrieNode() {
        children = new TrieNode[26];
        word = null;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        char[] array = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < array.length; i++) {
            if (cur.children[array[i] - 'a'] == null) {
                cur.children[array[i] - 'a'] = new TrieNode();
            }
            cur = cur.children[array[i] - 'a'];
        }
        cur.word = word;
    }
}