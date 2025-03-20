package com.algorithm.leetcode_other;

import java.util.HashSet;

/**
 * @author hac
 * @date 2024/9/3 20:47
 */
public class T1539 {

    public int findKthPositive(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int cnt = 0;
        for (int i = 1; i <= arr[arr.length - 1] + k; i++) {
            if (!set.contains(i)) {
                cnt += 1;
                if (cnt == k) {
                    return i;
                }
            }
        }
        return 0;
    }


}
