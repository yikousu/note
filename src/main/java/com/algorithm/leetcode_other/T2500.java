package com.algorithm.leetcode_other;

/**
 * @author hac
 * @date 2024/8/26 18:16
 */
public class T2500 {
    public boolean[][] used = new boolean[51][51];

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 4}, {3, 3, 1}};
        T2500 obj = new T2500();
        System.out.println(obj.deleteGreatestValue(grid));
    }

    // 找到一行中最最大的元素  并标记已处理
    public int findMaxByRow(int[][] grid, int row) {
        int maxValue = -1;
        int maxIndex = -1;
        for (int i = 0; i < grid[0].length; i++) {
            if (!used[row][i] && grid[row][i] > maxValue) {
                maxValue = grid[row][i];
                maxIndex = i;
            }
        }
        if (maxIndex != -1) {
            used[row][maxIndex] = true;
        }
        return maxValue;
    }

    public int deleteGreatestValue(int[][] grid) {
        int res = 0;
        for (int j = 0; j < grid[0].length; j++) { // 列遍历次数
            int maxValue = -1;
            for (int i = 0; i < grid.length; i++) { // 行遍历次数
                int maxByRow = findMaxByRow(grid, i);
                if (maxValue < maxByRow)
                    maxValue = maxByRow;
            }
            res += maxValue;
        }
        return res;
    }
}
