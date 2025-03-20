package com.algorithm.labuladong.dfs_pailie;

import java.util.LinkedList;

public class SubSet {

    // 子集问题
    public static void fun(int[] arr) {
        backtrack(arr, 0, new LinkedList<>());
    }

    // 用start来保证元素的相对顺序，防止出现重复子集
    public static void backtrack(int[] arr, int start, LinkedList<Integer> track) {
        // 树的前序位置   结果处理  输出
        System.out.println(track);
        for (int i = start; i < arr.length; i++) {
            track.add(arr[i]);
            backtrack(arr, i + 1, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        fun(arr);
    }
}
