package com.algorithm.leetcode_other;

/**
 * @author hac
 * @date 2024/8/31 18:38
 */
public class T704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
