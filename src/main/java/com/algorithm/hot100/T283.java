package com.algorithm.hot100;

import java.util.Arrays;

// 输入: nums = [0,1,0,3,12]
// 输出: [1,3,12,0,0]
// 实现0后移  保持其他元素相对位置
public class T283 {
    public static void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int index = -1;
        // 快慢指针
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[index + 1];
                nums[index + 1] = temp;
                index++;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
