package com.algorithm.leetcode_other;

/**
 * @author hac
 * @date 2024/8/26 0:06
 */
public class T1137 {
    public int tribonacci(int n) {
        int[] table = new int[38];
        table[0] = 0;
        table[1] = 1;
        table[2] = 1;
        if (n < 3) {
            return table[n];
        }
        for (int i = 3; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2] + table[i - 3];
        }
        return table[n];
    }
}
