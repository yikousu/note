package com.algorithm.labuladong.land;

public class T200 {
    // 岛屿数量

    // 方向数组
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    // dfs会把相邻的全部变成水
    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        for (int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }

    // 力扣200
    public static void main(String[] args) {
        char[][] grid = {
                {'0', '0', '0', '1', '0'},
                {'0', '0', '1', '1', '1'},
                {'0', '0', '0', '1', '0'},
                {'1', '0', '1', '1', '0'}
        };
        System.out.println(numIslands(grid));
    }
}
