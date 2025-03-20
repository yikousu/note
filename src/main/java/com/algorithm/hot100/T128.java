package com.algorithm.hot100;

import java.util.Arrays;

public class T128 {
    // 输入未排序：nums = [100,4,200,1,3,2]  输出：4    用0(n)的时间复杂度
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        Arrays.sort(nums);

        int res = 0;
        int cnt = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            if ((nums[i] + 1) == nums[i + 1]) {
                cnt++;
            } else {
                res = Math.max(res, cnt);
                cnt = 1;
            }
        }
        return Math.max(res, cnt);
    }


    public static void main(String[] args) {
        // 不能排序
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums));
    }
}
