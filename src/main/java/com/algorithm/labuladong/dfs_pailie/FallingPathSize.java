package com.algorithm.labuladong.dfs_pailie;


import java.util.Arrays;

public class FallingPathSize {
    public static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }


    // 931下降路径最小和
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;// 总行 列数  因为方形
        int res = Integer.MAX_VALUE;
        int[][] memo = new int[n][n];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], 66666);
        }
        for (int j = 0; j < n; j++) {// 在这里遍历选择
            res = Math.min(res, dp(matrix, n - 1, j, memo));
        }
        return res;
    }

    public static int dp(int[][] matrix, int i, int j, int[][] memo) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 99999;// 返回一个特殊值
        }
        // base case
        if (i == 0) return matrix[0][j];
        if (memo[i][j] != 66666) return memo[i][j];
        memo[i][j] = matrix[i][j] + min(dp(matrix, i - 1, j, memo),
                dp(matrix, i - 1, j - 1, memo), dp(matrix, i - 1, j + 1, memo));
        return memo[i][j];
    }


    public static void main(String[] args) {
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        System.out.println(minFallingPathSum(matrix));
    }

}
