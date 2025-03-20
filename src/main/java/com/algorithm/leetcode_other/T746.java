package com.algorithm.leetcode_other;

/**
 * @author hac
 * @date 2024/9/1 10:05
 */
public class T746 {
    public int minCostClimbingStairs(int[] cost) {
        int res = 0;
        // first second 是目标楼梯下面两个楼梯的最小花费
        // 顺序 first(上上个楼梯)  second(上一个楼梯)  res(目标楼梯)
        int first = 0, second = 0;
        for (int i = 2; i <= cost.length; i++) {
            res = Math.min(second + cost[i - 1], first + cost[i - 2]);
            // 只与前两个状态有关  所以用两个变量记录前两个状态即可
            first = second;
            second = res;
        }
        return res;
    }
}
