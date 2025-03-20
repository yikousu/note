package com.algorithm.hot100;

import java.util.List;

/**
 * @author hac
 * @date 2024/9/5 11:53
 */
public class T139 {


    public boolean wordBreak(String s, List<String> wordDict) {
        // ① 定义状态  dp[i] 表示 s 的前 i 个字符是否可以被拆分
        boolean[] dp = new boolean[s.length() + 1];

        // ② 初始化状态   dp[0] 为 true，表示空字符串可以被拆分
        dp[0] = true;

        // ③ 状态转移
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // 检查 s[j:i] 是否在字典中，并且 dp[j] 为 true（表示前 j 个字符可以被拆分）
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
