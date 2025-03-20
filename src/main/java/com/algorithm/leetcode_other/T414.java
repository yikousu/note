package com.algorithm.leetcode_other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author hac
 * @date 2024/8/24 11:26
 */
public class T414 {
    // 返回第三大的数字
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> stack = new LinkedList<>();
        for (int num : nums) {
            if (!stack.contains(num)) {
                stack.push(num);
            }
        }
        int cnt = 0;
        int res = nums[0];
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            if (cnt == 0) {
                res = pop;
            }
            cnt += 1;
            if (cnt >= 3) return pop;
        }

        return res;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
    }
}
