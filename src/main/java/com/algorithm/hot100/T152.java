package com.algorithm.hot100;

/**
 * @author hac
 * @date 2024/9/4 20:03
 */
public class T152 {
    public int maxProduct1(int[] nums) {
        int res = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }
            currentMax = Math.max(nums[i], currentMax * nums[i]);
            currentMin = Math.min(nums[i], currentMin * nums[i]);
            res = Math.max(res, currentMax);
        }
        return res;
    }

    public int maxProduct(int[] nums) {
        // 初始化最大乘积、当前最大值、当前最小值
        int res = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        // 从第二个元素开始遍历
        for (int i = 1; i < nums.length; i++) {
            // 如果当前数是负数，则交换当前最大值和最小值
            if (nums[i] < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }

            // 更新当前最大值和最小值
            currentMax = Math.max(nums[i], currentMax * nums[i]);
            currentMin = Math.min(nums[i], currentMin * nums[i]);

            // 更新最大乘积
            res = Math.max(res, currentMax);
        }
        return res;
    }
}
