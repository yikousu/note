package com.algorithm.leetcode_other;

import java.util.HashMap;

/**
 * @author hac
 * @date 2024/8/29 20:13
 */
public class T594 {
    public static int findLHS(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, (1 + map.getOrDefault(num, 0)));
        }

        for (Integer i : map.keySet()) {
            if (map.containsKey(i + 1)) {
                res = Math.max(res, map.get(i) + map.get(i + 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 2, 5, 2, 3, 7, 2, 2, 3};
        System.out.println(findLHS(arr));
    }
}
