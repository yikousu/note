package com.algorithm.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hac
 * @date 2024/7/3 16:57
 */
public class T238 {
    public static int[] productExceptSelf(int[] nums) {
        int temp = 1;
        int zero = 0;
        // 先看数组中0的个数  大于1则结果数组全为0  等于1则结果数组中0的位置为其他元素乘积
        for (int num : nums) {
            if (num != 0) {
                temp *= num;
            } else {
                zero++;
                if (zero > 1) return new int[nums.length];
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (zero == 1) {
                // num==0 则当前结果数组该位置的结果为其他元素乘积
                res.add(num == 0 ? temp : 0);
            } else {
                res.add(temp / num);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    // 优化
    public static int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // 第一次遍历，计算左边所有元素的乘积
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // 第二次遍历，计算右边所有元素的乘积，并更新结果数组
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right; // res[i]是当前i左边元素全部乘积
            right *= nums[i]; // 用一个变量记录当前元素右边的所有元素乘积
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
