package com.algorithm.hot100;

import java.util.Stack;

/**
 * @author hac
 * @date 2024/9/12 10:12
 */
public class T23 {
    public static int longestValidParentheses(String s) {
        int maxLength = 0;
        int[] dp = new int[s.length()]; // dp[i] 表示以 i 结尾的最长有效括号子串长度

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                // 情况1：()，直接加上前面的 dp 值
                if (s.charAt(i - 1) == '(') {
                    // dp[i] = dp[i-2] + 2，如果 i-2 >= 0，则加上之前的有效长度
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                // 情况2：))，检查前一个有效括号子串的前一个字符是否是 (
                else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // // dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
        }
        return maxLength;
    }

    public static int longestValidParentheses2(String s) {
        Stack<Integer> stack = new Stack<>();

        stack.push(-1); // 初始化栈底元素为-1，作为基准
        int maxLength = 0; // 保存最长有效括号子串长度

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i); // 左括号的索引压入栈
            } else {
                stack.pop(); // 右括号，弹出栈顶元素
                if (stack.isEmpty()) {
                    // 如果栈为空，将当前右括号的索引作为新的基准
                    stack.push(i);
                } else {
                    // 计算有效括号的长度
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        T23 obj = new T23();
        System.out.println(obj.longestValidParentheses("()(())"));
    }
}
