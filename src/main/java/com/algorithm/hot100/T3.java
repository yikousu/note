package com.algorithm.hot100;

import java.util.HashMap;

public class T3 {// 无重复字符的最长子串

    // 滑动窗口①什么时候移动左边指针?②什么时候移动右边指针?
    //③当移动某一边的时候就需要对结果进行动态变化
    // 求s中最长子串【字串不能有相同元素】
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        char[] charArray = s.toCharArray(); // 一般字符串的题，都可以先转为字符数组
        HashMap<Character, Integer> map = new HashMap<>(); // 用于存储字符及其在字符串中的位置
        int max = 0, left = 0;// left记录窗口左边指针

        for (int i = 0; i < charArray.length; i++) {
            if (map.containsKey(charArray[i])) {
                //①如果窗口中有重复元素【怎么知道？用一个map记录窗体中的元素！！】，则左边指针需要往右边移动
                //②因为可能abc123ca当遇到后者a，left大于 map.get(charArray[i]) + 1  所以需要两者取较大者
                left = Math.max(left, map.get(charArray[i]) + 1); // 两个元素重复了  left跳到前者元素右边
            }
            map.put(charArray[i], i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        char[] charArray = s.toCharArray();
        int res = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            if (map.containsKey(charArray[i])) {
                left = Math.max(left, map.get(charArray[i]) + 1);
            }

            map.put(charArray[i], i);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring2(s)); // 输出: 3，对应的最长子串为"abc"
    }
}
