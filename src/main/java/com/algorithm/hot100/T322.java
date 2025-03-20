package com.algorithm.hot100;

import java.util.Arrays;

/**
 * @author hac
 * @date 2024/9/5 11:05
 */
public class T322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChange1(int[] coins, int amount) {
        // ①初始化 dp 数组，dp[i] 表示凑齐金额 i 所需的最少硬币数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 2);// 因为我们要找的是最小值，所以初始化为一个最大值，之后会被更新

        // ②初始化状态
        dp[0] = 0;

        // ③ 状态转移
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // 如果 dp[amount] 没有被更新，表示无法凑出该金额，返回 -1
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
