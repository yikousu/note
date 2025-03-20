package com.algorithm.leetcode_other;

import java.util.HashSet;

/**
 * @author hac
 * @date 2024/8/29 17:03
 */
public class T633 {
    public boolean judgeSquareSum(int c) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i <= (int) Math.sqrt(c); i++) {
            set.add(i * i);
            if (set.contains(c - i * i)) {
                return true;
            }
        }
        return false;
    }
}
