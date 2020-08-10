package com.sld.dynamicprogramming;

/**
 * @author sld
 * <p>
 * leetcode 651
 * https://leetcode.com/problems/4-keys-keyboard/
 */
public class FourKeysKeyboard {

    public static void main(String[] args) {
        int N = 7;
        System.out.println(maxA2(N));
    }

    //方法一：
    //最简单的方法就是遍历所有的情况然后取最大值，打印A的次数在[1, N-3]之间，
    // 粘贴的次数为N-2-i，加上打印出的部分，就是N-1-i了
    private static int maxA(int N) {
        int result = N;
        for (int i = 1; i < N - 2; i++) {
            //N=7, maxA(1)*(7-1-1)  maxA(2)*(7-1-2)
            //maxA(3)*(7-1-3)  maxA(4)*(7-1-4)
            //maxA(1)*(7-1-1)代表一个A，打印四次，所以一共是五个A，
            //即A Ctrl-A Ctrl-C Ctrl-V Ctrl-V Ctrl-V Ctrl-V --> 五个A
            result = Math.max(result, maxA(i) * (N - i - 1));
        }
        return result;
    }

    //方法二：动态规划
    private static int maxA2(int N) {
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = i;
            for (int j = 1; j < i - 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
            }
        }
        return dp[N];
    }
}
