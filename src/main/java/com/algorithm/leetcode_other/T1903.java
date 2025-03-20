package com.algorithm.leetcode_other;

/**
 * @author hac
 * @date 2024/8/26 17:34
 */
public class T1903 {
    public String largestOddNumber(String num) {
        if ((num.charAt(num.length() - 1) & 1) == 1) return num;
        String res = "";
        for (int i = num.length() - 1 - 1; i >= 0; i--) {
            if ((num.charAt(i) & 1) == 1) {
                res = num.substring(0, i + 1);
                break;
            }
        }
        return res;
    }
}
