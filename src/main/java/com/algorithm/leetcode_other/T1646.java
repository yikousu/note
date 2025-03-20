package com.algorithm.leetcode_other;

/**
 * @author hac
 * @date 2024/8/26 18:08
 */
public class T1646 {
    public static int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        int[] nums = new int[101];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 0; i <= n; i++) {
            if (2 * i >= 2 && 2 * i <= n) nums[2 * i] = nums[i];
            if ((2 * i + 1) >= 2 && (2 * i + 1) <= n) nums[2 * i + 1] = nums[i] + nums[i + 1];
        }
        int res = 0;
        for (int num : nums) {
            if (num > res) res = num;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getMaximumGenerated(0));
    }
}
