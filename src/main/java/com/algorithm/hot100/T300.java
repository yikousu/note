package com.algorithm.hot100;

import java.util.Arrays;

/**
 * @author hac
 * @date 2024/9/5 12:20
 */
public class T300 {

    public int lengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 1;
        for (int i : dp) {
            if (i > max) max = i;
        }
        return max;
    }

    public int lengthOfLIS(int[] nums) {
        // ①定义状态 dp[i] 表示以 nums[i] 结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];

        // ②初始化状态
        Arrays.fill(dp, 1); // 初始化 dp 数组，每个元素默认长度为 1


        // 状态转移
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { // 如果 nums[i] 可以接在 nums[j] 后面
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = 1;
        for (int i : dp) {
            if (i > maxLength) maxLength = i;
        }

        return maxLength;
    }
}
