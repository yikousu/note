package com.algorithm.hot100;

/**
 * @author hac
 * @date 2024/9/5 12:33
 */
public class T416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        // 和为奇数时，不可能划分成两个和相等的集合
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        // ①定义状态  dp[i][j] 表示前i个数中能否选出若干个  使得和为 j(j为背包容量)  则为true  否则false
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        // ②初始化状态
        for (int i = 0; i <= nums.length; i++)
            dp[i][0] = true; // 背包容量为 0 时  不选任何物品就满足

        // ③状态转移
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - nums[i - 1] < 0) {
                    // 背包容量不足，不能装入第 i 个物品
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 装入或不装入背包
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][target];
    }

    public boolean canPartition1(int[] nums) {
        // 计算数组总和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 如果总和为奇数，无法分成两个子集
        if (sum % 2 != 0) return false;
        // 目标和是总和的一半
        int target = sum / 2;

        // ①定义状态  dp[i] 表示是否可以选出若干个元素，使得和为 i
        boolean[] dp = new boolean[target + 1];

        // ②初始化状态
        dp[0] = true;

        // ③状态转移
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j] | dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }


}
