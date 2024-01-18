package com.sld.string;

/**
 * @author sld
 * <p>
 * leetcode 1208
 * https://leetcode.com/problems/get-equal-substrings-within-budget/
 */
class GetEqualSubstringsWithinBudget {

    public static void main(String[] args) {
        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;
        System.out.println(equalSubstring(s, t, maxCost));
    }

    private static int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int result = 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < length) {
            sum += arr[right];
            while (sum > maxCost) {
                sum -= arr[left];
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
    }
}