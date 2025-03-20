package com.algorithm.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hac
 * @date 2024/6/22 22:17
 */
public class T560 {
    public static int subarraySum(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        //
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // sum[i...j]=sum[j]-sum[i-1]
            currentSum += nums[i];
            if (map.containsKey(currentSum - k)) {
                res += map.get(currentSum - k);
            }
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 0};
        int k = 0;
        System.out.println(subarraySum(nums, k));
    }
}
