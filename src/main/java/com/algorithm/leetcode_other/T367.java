package com.algorithm.leetcode_other;

/**
 * @author hac
 * @date 2024/8/27 17:27
 */
public class T367 {

    public static void main(String[] args) {

    }

    public boolean isPerfectSquare1(int num) {
        if (num == 1) return true;
        for (int i = 0; i < num / 2 + 1; i++) {
            if (i * i > num) return false; // 优化就不超时了
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }

    public boolean isPerfectSquare(int num) {
        double sqrt = Math.sqrt(num);
        if (Math.abs((int) sqrt - sqrt) < 0.0000000001) return true;
        return false;
    }
}
