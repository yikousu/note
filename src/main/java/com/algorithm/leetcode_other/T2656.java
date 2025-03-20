package com.algorithm.leetcode_other;

/**
 * @author hac
 * @date 2024/8/26 17:50
 */
public class T2656 {
    public int maximizeSum(int[] nums, int k) {
        int maxValue = nums[0];
        for (int num : nums) {
            if (maxValue < num) maxValue = num;
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            res += maxValue + i;
        }
        return res;
    }
}
