package com.algorithm.written_test.shuzi_zhejiang;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hac
 * @date 2025/4/15
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取信封数量
        int n = scanner.nextInt();
        int[][] envelopes = new int[n][2];

        // 读取每个信封的长度和宽度
        for (int i = 0; i < n; i++) {
            envelopes[i][0] = scanner.nextInt();
            envelopes[i][1] = scanner.nextInt();
        }

        // 按宽度升序排序，如果宽度相同，则按高度降序排序
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        // 动态规划找最长递增子序列（基于高度）
        int[] dp = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1; // 每个信封至少可以单独作为一层
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        // 输出结果
        System.out.println(max);

        scanner.close();
    }
}
