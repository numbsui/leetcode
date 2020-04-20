package com.sld.dynamicprogramming;

/**
 * @author sld
 * <p>
 * leetcode 72
 * https://leetcode.com/problems/edit-distance/
 * <p>
 * 字符串类的DP问题，状态是不容易定义的，一般可定义为：DP[i][j]
 * 对于此问题，状态方程可定义为：DP[i][j] i表示word1前i个字符 j表示word2前j个字符
 * 那么DP方程为：DP[i][j] =
 *              if word1[i] == word2[j]
 *                  DP[i-1][j-1]
 *              else
 *                  1+Min(DP[i-1][j], DP[i][j-1], DP[i-1][j-1])
 * 上述else中三个表示insert delete replace
 */
public class EditDistance {
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(minDistance(word1, word2));
    }

    private static int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
