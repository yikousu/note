package com.algorithm.labuladong.dfs_pailie;

import java.util.Arrays;
import java.util.LinkedList;

public class ZuHe1 {

    // 力扣40组合总和  给你一个数组+target输出和为target的组合
    public static void fun(int[] arr, int target) {
        Arrays.sort(arr);//①先排序
        backtrack(arr, 0, target, new LinkedList<>());
    }

    // 用start来保证元素的相对顺序，防止出现重复子集    同一层有相同的才剪枝
    public static void backtrack(int[] arr, int start, int target, LinkedList<Integer> track) {
        // 树的前序位置   结果处理  输出
        int sum = 0;// 可以做选择撤销选择哪里求和
        for (int i = 0; i < track.size(); i++) {
            sum += track.get(i);
        }
        if (sum == target) System.out.println(track);
        if (sum > target) return;
        for (int i = start; i < arr.length; i++) {
            //② i>start!!!   i>0就是去重了【因为重复元素】 同一层有相同的才剪枝
            if (i > start && arr[i] == arr[i - 1]) continue;
            track.add(arr[i]);
            backtrack(arr, i + 1, target, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        fun(arr, 8);
    }
}
