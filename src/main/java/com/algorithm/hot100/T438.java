package com.algorithm.hot100;


import java.util.*;

public class T438 {
    // 输入: s = "cbaebabacd", p = "abc"

    // 自己写的超时了(第一种)
    public static boolean check(String s, String p) {
        char[] charArray1 = s.toCharArray();
        Arrays.sort(charArray1);

        char[] charArray2 = p.toCharArray();
        Arrays.sort(charArray2);

        if ((new String(charArray1)).equals((new String(charArray2)))) {
            return true;
        }
        return false;
    }

    public static List<Integer> findAnagramsMe(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        char[] charArray = s.toCharArray();
        for (int l = 0, h = p.length() - 1; h < charArray.length; h++, l++) {
            if (check(s.substring(l, h + 1), p)) {
                res.add(l);
            }
        }
        return res;
    }

    // 自己写的通过了  抽取了一些东西出来  不然也是超时
    public static String stringSort(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public static List<Integer> findAnagramsMe2(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;

        String sortedP = stringSort(p);
        int s_len = s.toCharArray().length;
        int p_len = p.toCharArray().length;
        int left = 0, right = 0;
        while (right < s_len) {
            if (right - left + 1 == p_len) {
                if (stringSort(s.substring(left, right + 1)).equals(sortedP)) {
                    res.add(left);
                }
                left++;
                right++;
            } else {
                right++;
            }
        }
        return res;
    }


    // 输入: s = "cbaebabacd", p = "abc" 找到字符串中所有字母异位词
    public static List<Integer> findAnagramsSimply(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] cnt = new int[26]; // 初始化一个数组来统计字符串 p 中每个字符的出现次数
        for (int i = 0; i < p.length(); i++) {
            cnt[p.charAt(i) - 'a']++; // 统计模式字符串 p 中每个字符的出现次数
        }
        int l = 0, r = 0;  // l 和 r 分别表示滑动窗口的左右边界
        // 遍历字符串 s
        // 加入窗口就减1   移除窗口就加1
        while (r < s.length()) {
            // 更新当前窗口中字符的计数数组
            cnt[s.charAt(r) - 'a']--; // 将当前字符的计数减一，表示加入当前窗口
            // 从左侧收缩窗口，直到当前字符的计数在限定范围内
            while (cnt[s.charAt(r) - 'a'] < 0) {
                cnt[s.charAt(l) - 'a']++; // 将左边界指向的字符的计数加一，表示从当前窗口中移除
                l++;
            }
            // 检查当前窗口大小是否等于字符串 p 的大小
            if (r - l + 1 == p.length()) {
                res.add(l); // 如果当前窗口大小等于字符串 p 的大小，将左边界指针 l 添加到结果列表中
            }
            r++; // 移动右边界指针，扩展窗口
        }
        return res; // 返回结果列表
    }

    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] cnt = new int[26];
        for (int i = 0; i < p.length(); i++) {
            cnt[p.charAt(i) - 'a']++;
        }
        int l = 0, h = 0;
        while (h < s.length()) {
            cnt[s.charAt(h) - 'a']--;
            while (cnt[s.charAt(h) - 'a'] < 0) {
                cnt[s.charAt(l) - 'a']++;
                l++;
            }
            if (h - l + 1 == p.length()) {
                res.add(l);
            }
            h++;
        }
        return res;
    }

    // labuladong
    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();// window 用于存储字符串 s 当前窗口中字符的频率。
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>(); // 记录结果
        // 我们使用两个指针 left 和 right 来遍历字符串 s。right 指针向右移动，扩展当前窗口，直到窗口包含了模式字符串 p 的所有字符。
        // 在每一步中，我们都会更新 window 这个哈希表，记录当前窗口中每个字符的出现次数。
        // 如果当前窗口中的字符出现次数符合模式字符串 p 中字符的出现次数，我们就将 valid 这个计数器加一。
        // 当窗口的大小等于模式字符串 p 的长度时，我们检查 valid 是否等于 need 哈希表中键值对的个数。如果是，说明当前窗口包含了一个字谜，我们将窗口的起始索引加入结果列表 res 中。
        // 然后，我们移动 left 指针，并相应地更新窗口中字符的出现次数，直到窗口再次满足条件。
        // 重复以上步骤，直到 right 指针遍历完整个字符串 s。
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= p.length()) {
                // 当窗口符合条件时，把起始索引加入 res
                if (valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                // if (need.containsKey(d)) { ... }: 这个条件语句用来检查移除的字符是否在模式字符串 p 中
                // 只有当移除的字符是模式字符串中的字符时，才需要更新窗口中字符的出现次数。

                // 因为可能有重复的字符串
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String t = "abc";
        List<Integer> result = findAnagrams2(s, t);
        System.out.println(result); // Output: [0, 6]
    }
}
