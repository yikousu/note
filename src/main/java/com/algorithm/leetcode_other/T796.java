package com.algorithm.leetcode_other;

import java.util.LinkedList;

/**
 * @author hac
 * @date 2024/9/1 10:37
 */
public class T796 {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        LinkedList<Character> list = new LinkedList<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            list.addLast(c);
        }
        for (int i = 0; i < list.size(); i++) {
            list.addFirst(list.removeLast());
            StringBuilder builder = new StringBuilder();
            list.stream().forEach(builder::append);
            if (builder.toString().equals(goal)) return true;
        }
        return false;
    }
}
