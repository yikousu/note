package com.algorithm.leetcode_other;

/**
 * @author hac
 * @date 2024/9/1 11:37
 */
public class T905 {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[nums.length];
        for (int i = 0; left < right; i++) {
            if ((nums[i] & 1) == 0) {
                res[left++] = nums[i];
            } else {
                res[right--] = nums[i];
            }

        }
        return res;
    }
}
