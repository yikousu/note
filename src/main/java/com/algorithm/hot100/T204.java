package com.algorithm.hot100;

import java.util.Arrays;

/**
 * @author hac
 * @date 2024/9/4 22:03
 */
public class T204 {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        // boolean 数组，初始时假设所有数都是质数
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true); // 全部初始化为true

        // 从 2 开始筛选
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // 将 i 的倍数标记为非质数
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        // 统计质数的数量
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
