package com.algorithm.leetcode_other;

/**
 * @author hac
 * @date 2024/8/29 17:13
 */
public class T504 {
    public static String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder res = new StringBuilder();
        int flag = num < 0 ? -1 : 1;
        num = Math.abs(num);
        while (num > 0) {
            res.append(num % 7);
            num /= 7;
        }
        return flag == 1 ? res.reverse().toString() : "-" + res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToBase7(-7));
    }
}
