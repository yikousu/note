package com.algorithm.labuladong.dfs_pailie;

import java.util.Arrays;
import java.util.LinkedList;

public class SubSet1 {
    // 子集问题[元素可以重复不可复选]
    public static void fun(int[] arr) {
        Arrays.sort(arr);//①先排序
        backtrack(arr, 0, new LinkedList<>());
    }

    // 用start来保证元素的相对顺序，防止出现重复子集    同一层有相同的才剪枝
    public static void backtrack(int[] arr, int start, LinkedList<Integer> track) {
        // 树的前序位置   结果处理  输出
        System.out.println(track);
        for (int i = start; i < arr.length; i++) {
            //② i>start!!!   i>0就是去重了【因为重复元素】 同一层有相同的才剪枝
            if (i > start && arr[i] == arr[i - 1]) {
                continue;
            }
            track.add(arr[i]);
            backtrack(arr, i + 1, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        fun(arr);
    }
}
