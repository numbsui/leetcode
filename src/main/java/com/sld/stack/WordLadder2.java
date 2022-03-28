package com.sld.stack;

import java.util.*;

/**
 * @author sld
 * <p>
 * leetcode 127
 * https://leetcode.com/problems/word-ladder/
 */
public class WordLadder2 {

    /**
     * 按字典 wordList 完成从单词 beginWord 到单词 endWord 转化，一个表示此过程的 转换序列 是形式上像 beginWord -> s1 -> s2 -> ... -> sk
     * 这样的单词序列，并满足：
     * 每对相邻的单词之间仅有单个字母不同。
     * 转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单词。
     * sk == endWord
     * 给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。请你找出并返回所有从 beginWord 到 endWord 的 最短转换序列 ，如果不存在这样
     * 的转换序列，返回一个空列表。每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。
     */
    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        System.out.println(findLadders(beginWord, endWord, wordList));

    }

    private static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //结果
        List<List<String>> result = new ArrayList<>();
        //去重列表
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord))
            return result;
        wordSet.remove(beginWord);
        //记录访问过的单词
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        //初始单词列表放入队列
        Queue<List<String>> queue = new LinkedList<>();
        List<String> beginList = new ArrayList<>();
        beginList.add(beginWord);
        queue.add(beginList);

        boolean isFound = false;
        while (!queue.isEmpty()) {
            int count = queue.size();
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < count; i++) {
                List<String> list = queue.poll();
                String lastWord = list.get(list.size() - 1);
                ArrayList<String> neighbors = getNeighbors(lastWord, wordSet);
                for (String neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        if (endWord.equals(neighbor)) {
                            isFound = true;
                            list.add(neighbor);
                            result.add(new ArrayList<>(list));
                            list.remove(list.size() - 1);
                        }
                        list.add(neighbor);
                        queue.add(new ArrayList<>(list));
                        list.remove(list.size() - 1);
                        subVisited.add(neighbor);
                    }
                }
            }
            visited.addAll(subVisited);
            if (isFound) break;
        }
        return result;
    }

    private static ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        char chs[] = node.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch)
                    continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

}