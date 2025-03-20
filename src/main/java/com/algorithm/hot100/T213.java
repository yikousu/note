package com.algorithm.hot100;

/**
 * @author hac
 * @date 2024/9/4 19:19
 */
public class T213 {
    private static int extracted(int[] nums, int start, int end) {
        int dpi_2 = nums[start];
        int dpi_1 = Math.max(nums[start], nums[start + 1]);
        // ③状态转移
        for (int i = start + 2; i <= end; i++) {
            int temp = Math.max(dpi_2 + nums[i], dpi_1);
            dpi_2 = dpi_1;
            dpi_1 = temp;
        }
        return dpi_1;
    }

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(
                extracted(nums, 0, nums.length - 2),
                extracted(nums, 1, nums.length - 1)
        );
    }
}
