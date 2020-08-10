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

    //给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
    //
    //你可以对一个单词进行如下三种操作：
    //
    //插入一个字符
    //删除一个字符
    //替换一个字符
    //
    //输入：word1 = "horse", word2 = "ros"
    //输出：3
    //解释：
    //horse -> rorse (将 'h' 替换为 'r')
    //rorse -> rose (删除 'r')
    //rose -> ros (删除 'e')
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
