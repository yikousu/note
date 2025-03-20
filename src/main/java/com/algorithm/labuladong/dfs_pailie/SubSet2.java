package com.algorithm.labuladong.dfs_pailie;

import java.util.Arrays;
import java.util.LinkedList;

public class SubSet2 {


    public static int sumArray(LinkedList<Integer> track) {
        int sum = 0;
        for (int i = 0; i < track.size(); i++) {
            sum += track.get(i);
        }
        return sum;
    }

    // 子集/组合 问题[元素不重复可复选]
    public static void fun(int[] arr, int target) {
        Arrays.sort(arr);//①先排序
        backtrack(arr, 0, target, new LinkedList<>());
    }

    // 用start来保证元素的相对顺序，防止出现重复子集    同一层有相同的才剪枝
    public static void backtrack(int[] arr, int start, int target, LinkedList<Integer> track) {
        // 树的前序位置   结果处理  输出
        if (sumArray(track) == target) System.out.println(track);// 自定义函数 也可选择撤销选择那块求和
        if (sumArray(track) > target) return;// base case
        for (int i = start; i < arr.length; i++) {
            //
            if (i > start && arr[i] == arr[i - 1]) continue;
            track.add(arr[i]);
            // 将i+1改成i就表示某元素可以重复利用
            // backtrack(arr, i+1 , target, track);
            backtrack(arr, i, target, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        fun(arr, 7);
    }
}
