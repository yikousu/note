package com.algorithm.leetcode_other;

/**
 * @author hac
 * @date 2024/8/27 16:43
 */
public class T258 {
    public static int addDigits(int num) {
        int temp = 0;
        while (num / 10 > 0) {
            while (num > 0) {
                temp += num % 10;
                num /= 10;
            }
            num = temp;
            temp = 0;
        }
        return num;

    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
}
