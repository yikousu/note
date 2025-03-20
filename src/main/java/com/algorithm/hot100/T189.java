package com.algorithm.hot100;

import java.util.Arrays;

/**
 * @author hac
 * @date 2024/7/3 16:37
 */
public class T189 {
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotate1(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        int j = 0;
        k = k % nums.length; // 数组长度大于k时，旋转次数取余---关键
        for (int i = nums.length - k; i < nums.length; i++) {
            temp[j++] = nums[i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            temp[j++] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
