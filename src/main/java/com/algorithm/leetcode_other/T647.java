package com.algorithm.leetcode_other;

/**
 * @author hac
 * @date 2025/3/24 20:32
 */
public class T647 {
    public int countSubstrings_backup(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));
                StringBuilder temp = new StringBuilder(sb); // 因为reverse是原地修改的，所以需要创建一个副本
                if (sb.toString().equals(temp.reverse().toString())) {
                    res += 1;
                }
            }
        }
        return res;
    }

    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += count(s, i, i);
            res += count(s, i, i + 1);
        }
        return res;

    }

    private int count(String s, int l, int r) {
        int cnt = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            cnt += 1;
            l -= 1;
            r += 1;
        }
        return cnt;
    }
}
