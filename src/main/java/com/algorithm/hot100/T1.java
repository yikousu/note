package com.algorithm.hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hac
 * @date 2024/6/19 16:53
 */
public class T1 {
    public static int[] twoSum(int[] nums, int target) {
        // 用map的contains   map可以存值和下标
        // key:值   value:下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
