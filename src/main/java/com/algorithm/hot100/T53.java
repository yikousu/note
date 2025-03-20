package com.algorithm.hot100;

/**
 * @author hac
 * @date 2024/6/27 16:28
 */
public class T53 {
    // 动态规划 【最大子数组之和】
    // 方法一 官方
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length]; // dp[i] 表示以 nums[i] 结尾的最大子数组和。
        dp[0] = nums[0]; // 初始化状态

        int maxSum = dp[0]; // 初始化最大子数组和

        // 动态规划状态转移
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);  // 状态转移方程
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum; // 返回最大子数组和
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums)); // 输出: 6
    }

    // 方法二
    public int maxSubArray1(int[] nums) {
        // 初始化为int类型最小值
        int res = nums[0];
        // 0任何数等于任何数
        int tempTotal = 0;
        for (int i = 0; i < nums.length; i++) {
            tempTotal += nums[i];
            // 记录最大数值
            res = Math.max(tempTotal, res);
            if (tempTotal < 0) {
                // 如果和小于0,就重置为0，因为任何数加上一个负数一定小于当前数值
                tempTotal = 0;
            }
        }
        return res;
    }
}
