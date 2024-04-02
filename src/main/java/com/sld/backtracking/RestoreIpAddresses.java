package com.sld.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sld
 * <p>
 * leetcode 93
 * https://leetcode.cn/problems/restore-ip-addresses/
 */
public class RestoreIpAddresses {

    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));
    }

    private static List<String> restoreIpAddresses(String s) {
        int count = 4;
        int[] arr = new int[count];
        List<String> result = new ArrayList<>();
        dfs(result, 0, 0, s, arr, count);
        return result;
    }

    private static void dfs(List<String> result, int index, int start, String s, int[] arr, int count) {
        if (index == count) {
            if (start == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    sb.append(arr[i]).append(".");
                }
                String str = sb.toString();
                result.add(str.substring(0, str.length() - 1));
            }
            return;
        }

        if (start == s.length()) {
            return;
        }

        if (s.charAt(start) == '0') {
            arr[index] = 0;
            dfs(result, index + 1, start + 1, s, arr, count);
            return;
        }

        int num = 0;
        for (int i = start; i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 0 && num <= 255) {
                arr[index] = num;
                dfs(result, index + 1, i + 1, s, arr, count);
            } else {
                break;
            }
        }
    }
}
