package com.algorithm.leetcode_other;

import java.util.Arrays;

/**
 * @author hac
 * @date 2024/8/29 21:10
 */
public class T628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }
}