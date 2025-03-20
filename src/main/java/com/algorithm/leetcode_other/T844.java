package com.algorithm.leetcode_other;

/**
 * @author hac
 * @date 2024/9/1 10:56
 */
public class T844 {
    public static boolean backspaceCompare(String s, String t) {
        return extracted(s).equals(extracted(t));
    }

    public static String extracted(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (res.length() > 0) res.deleteCharAt(res.length() - 1);
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));
    }
}
