package com.algorithm.written_test.company_mei_tuan;

// 通过v1.0   40min

import java.util.ArrayList;
import java.util.Scanner;

// 第一题
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<String> res = new ArrayList<>();

        while (N >= 0) {
            // 初始
            int p = 0;
            StringBuilder t = new StringBuilder();
            String s = in.nextLine();
            if (s == null || s.isEmpty()) { // 处理回车
                N--;
                continue;
            }
            // 处理每组输入
            for (int i = 0; i < s.length(); i++) {
                // 如果是数字
                if (Character.isDigit(s.charAt(i))) {
                    // p为0
                    if (p == 0) {
                        p = Integer.parseInt(s.charAt(i) + "");
                    } else {
                        // p不为0
                        p = p * 10 + Integer.parseInt(s.charAt(i) + "");
                    }
                } else { // 如果不是数字
                    // p不等于0 左移p位
                    if (p != 0) {
                        p = t.length() != 0 ? p % t.length() : p;
                        if (t.length() > 0) { // 防止下标越界
                            for (int j = 0; j < p; j++) {
                                t.append(t.charAt(0));
                                t.deleteCharAt(0);
                            }
                        }
                        p = 0;
                    }
                    if (s.charAt(i) == 'R') {
                        t.reverse();
                    } else {
                        t.append(s.charAt(i));
                    }
                }
            }
            res.add(t.toString());
            N -= 1;
        }
        for (String s : res) {
            System.out.println(s);
        }
    }
}