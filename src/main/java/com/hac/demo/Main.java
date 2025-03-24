package com.hac.demo;

/**
 * @author hac
 * @date 2025/3/24 20:03
 */
public class Main {
    public int countSubstrings(String s) {
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

    public static void main(String[] args) {

        Main main = new Main();
        System.out.println(main.countSubstrings("aba"));
    }
}
