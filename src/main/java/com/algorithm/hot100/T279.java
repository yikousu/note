package com.algorithm.hot100;

import java.util.Arrays;

/**
 * @author hac
 * @date 2024/9/4 20:21
 */
public class T279 {
    public static void main(String[] args) {
    }

    public int numSquares(int n) {
        // ①定义状态 dp[i] 表示和为 i 的完全平方数的最少数量
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 2); // 设置大于n即可

        // ②初始化状态
        dp[0] = 0;

        // ③状态转移
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public int numSquares1(int n) {
        //  ①定义状态 dp[i] 表示和为 i 的完全平方数的最少数量
        int[] dp = new int[n + 1];

        // ②初始化状态
        dp[0] = 0;

        // ③状态转移   从 1 开始遍历到 n，依次计算每个数字的最少完全平方数数量
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;

            // 遍历所有可能的完全平方数 j*j，使得 j*j <= i
            for (int j = 1; j * j <= i; j++) {
                // 更新当前数字 i 所需的最少完全平方数数量
                minn = Math.min(minn, dp[i - j * j]);
            }
            // 加 1 是因为我们使用了一个新的完全平方数
            dp[i] = minn + 1;
        }
        return dp[n];
    }
}
