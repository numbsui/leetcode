package com.sld.stack;

import java.util.Stack;

/**
 * @author sld
 * <p>
 * leetcode 71
 * https://leetcode.com/problems/simplify-path/
 */
public class SimplifyPath {

    /**
     * 给你一个字符串 path ，表示指向某一文件或目录的Unix 风格绝对路径（以 '/' 开头），请你将其转化为更加简洁的规范路径。
     * <p>
     * 在Unix风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点（..）表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。
     * 任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
     * <p>
     * 请注意，返回的 规范路径 必须遵循下述格式：
     * <p>
     * 始终以斜杠 '/' 开头。
     * 两个目录名之间必须只有一个斜杠 '/' 。
     * 最后一个目录名（如果存在）不能 以 '/' 结尾。
     * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
     * 返回简化后得到的 规范路径 。
     */
    public static void main(String[] args) {

        //String path = "/a/./b/../../c/";
        String path = "/../";
        System.out.println(simplifyPath(path));
    }

    private static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] strings = path.split("/");
        StringBuilder sb = new StringBuilder();
        //a . b .. .. c
        for (String string : strings) {
            if (!stack.isEmpty() && "..".equals(string)) {
                stack.pop();
            } else if (!" ..".contains(string)) {
                stack.push(string);
            }
        }

        for (String i : stack) {
            sb.append("/").append(i);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}


