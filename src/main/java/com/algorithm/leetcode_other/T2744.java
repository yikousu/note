package com.algorithm.leetcode_other;

import java.util.HashSet;

/**
 * @author hac
 * @date 2024/8/26 11:59
 */
public class T2744 {


    public static int maximumNumberOfStringPairs1(String[] words) {
        HashSet<String> set = new HashSet<>();
        int res = 0;
        for (String word : words) {
            if (word.charAt(1) == word.charAt(0)) continue;
            if (set.contains(word.charAt(1) + "" + word.charAt(0))) {
                res += 1;
            }
            set.add(word);
        }
        return res;
    }

    public static int maximumNumberOfStringPairs(String[] words) {
        HashSet<String> set = new HashSet<>();
        int count = 0;
        for (String word : words) {
            String reversed = "" + word.charAt(1) + word.charAt(0);
            // 检查反转字符串是否已经存在于 set 中
            if (set.contains(reversed)) {
                count++;
            }
            set.add(word);
        }
        return count;
    }


}
