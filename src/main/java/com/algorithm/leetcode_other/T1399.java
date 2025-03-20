package com.algorithm.leetcode_other;

import java.util.HashMap;

/**
 * @author hac
 * @date 2024/8/26 17:05
 */
public class T1399 {
    public static int sumDigit(int i) {
        int res = 0;
        while (i > 0) {
            res += i % 10;
            i /= 10;
        }
        return res;
    }

    public static int countLargestGroup(int n) {
        int maxCnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            Integer count = map.getOrDefault(sumDigit(i), 0) + 1;
            map.put(sumDigit(i), count);
            maxCnt = Math.max(maxCnt, count);
        }
        int res = 0;
        for (Integer value : map.values()) {
            if (value == maxCnt) {
                res += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countLargestGroup(13));
    }
}
