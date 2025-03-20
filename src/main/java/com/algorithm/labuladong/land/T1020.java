package com.algorithm.labuladong.land;

public class T1020 {
    // 飞地的数量
    public static int numEnclaves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, grid[0].length - 1);
        }

        for (int j = 0; j < grid[0].length; j++) {
            dfs(grid, 0, j);
            dfs(grid, grid.length - 1, j);
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) res++;
            }
        }
        return res;
    }

    public static void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 | i > grid.length - 1 || j > grid[0].length - 1) return;
        if (grid[i][j] == 0) return;
        grid[i][j] = 0;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        System.out.println(numEnclaves(grid));
    }
}
