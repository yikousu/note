package com.algorithm.leetcode_other;

/**
 * @author hac
 * @date 2024/9/1 9:50
 */
public class T2529 {
    public int maximumCount(int[] nums) {
        int neg = 0;
        int pos = 0;
        for (int num : nums) {
            if (num > 0) {
                pos += 1;
            } else if (num < 0) {
                neg += 1;
            }
        }
        return Math.max(neg, pos);
    }
}
