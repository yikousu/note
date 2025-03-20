package com.algorithm.leetcode_other;

/**
 * @author hac
 * @date 2024/8/29 17:41
 */
public class T557 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            res.append(new StringBuilder(word).reverse()).append(" ");
        }
        return res.toString().trim();
    }
}
