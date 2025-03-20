package com.algorithm.leetcode_other;

/**
 * @author hac
 * @date 2024/8/26 0:13
 */
public class T1668 {
    public static int maxRepeating1(String sequence, String word) {
        int maxRepeat = 0;
        StringBuilder repeatedWord = new StringBuilder(word);

        // 循环尝试增加word的重复次数，直到不再是子字符串
        while (sequence.contains(repeatedWord)) {
            maxRepeat++;
            repeatedWord.append(word);
        }

        return maxRepeat;
    }

    public static void main(String[] args) {
        String s1 = "aaa";
        String s2 = "a";
    }

    public int maxRepeating(String sequence, String word) {
        int res = 0;
        StringBuilder builder = new StringBuilder(word);
        while (sequence.contains(builder)) {
            res += 1;
            builder.append(word);
        }
        return res;
    }
}
