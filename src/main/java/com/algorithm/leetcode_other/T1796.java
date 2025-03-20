package com.algorithm.leetcode_other;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hac
 * @date 2024/8/26 12:47
 */
public class T1796 {
    public static int secondHighest(String s) {
        Set<Integer> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                set.add(c - '0');
            }
        }
        int firstMax = -1;
        int secondMax = -1;
        for (Integer i : set) {
            if (i > firstMax) {
                secondMax = firstMax;
                firstMax = i;
            } else if (i > secondMax && i < firstMax) {
                secondMax = i;
            }
        }
        return secondMax;
    }

    public static int secondHighest11(String s) {
        Set<Integer> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                set.add(c - '0');
            }
        }
        int maxValue = -1;
        for (Integer i : set) {
            if (i > maxValue) {
                maxValue = i;
            }
        }
        set.remove(maxValue);
        if (set.size() == 0) return -1;
        maxValue = -1;
        for (Integer i : set) {
            if (i > maxValue) {
                maxValue = i;
            }
        }
        return maxValue;
    }

    public static int secondHighest1(String s) {
        int first = -1, second = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                if (num > first) {
                    second = first;
                    first = num;
                } else if (num < first && num > second) {
                    second = num;
                }
            }
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(secondHighest1("ck077"));
    }
}
