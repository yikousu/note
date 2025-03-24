package com.algorithm.leetcode_other;

/**
 * @author hac
 * @date 2025/3/24 20:43
 */
public class T5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > maxLength) {
                maxLength = len;
                start = i - (len - 1) / 2; // 更新起点
            }
        }
        return s.substring(start, start + maxLength);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {

    }
}
