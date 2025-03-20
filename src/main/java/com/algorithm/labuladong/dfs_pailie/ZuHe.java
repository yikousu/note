package com.algorithm.labuladong.dfs_pailie;

import java.util.LinkedList;

public class ZuHe {

    // 组合【元素无重不可复选】
    // 就是子集问题  把size为k的搜集起来(某一层)
    public static void combine(int n, int k) {
        backtrack(1, n, k, new LinkedList<>());
    }

    // 用start来保证元素的相对顺序，防止出现重复子集
    public static void backtrack(int start, int n, int k, LinkedList<Integer> track) {
        // 树的前序位置   结果处理  输出
        if (track.size() == k) {
            System.out.println(track);
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(i + 1, n, k, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        combine(3, 2);
    }
}
