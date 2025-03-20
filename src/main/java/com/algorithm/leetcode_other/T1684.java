package com.algorithm.leetcode_other;

import java.util.HashSet;

/**
 * @author hac
 * @date 2024/9/3 21:33
 */
public class T1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;
        HashSet<Character> set = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            set.add(c);
        }
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!set.contains(c)) {
                    res += 1;
                    break;
                }
            }
        }
        return words.length - res;
    }
}
