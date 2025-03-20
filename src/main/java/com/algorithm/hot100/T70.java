package com.algorithm.hot100;

/**
 * @author hac
 * @date 2024/8/28 18:08
 */
public class T70 {
    public static int climbStairs(int n) {
        // 定义状态
        int[] dp = new int[n + 1];// dp[i]表示爬到第i层楼梯的方案数
        // 初始状态
        dp[0] = 1;
        dp[1] = 1;

        // 状态转移方程  dp[i] = dp[i-1]+dp[i-2];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
