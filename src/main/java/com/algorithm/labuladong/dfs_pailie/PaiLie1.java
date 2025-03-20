package com.algorithm.labuladong.dfs_pailie;

import java.util.LinkedList;

public class PaiLie1 {

    // 全排列【元素重复不可复选】
    public static void backtrack(int[] arr, LinkedList<Integer> track, boolean[] used) {
        if (track.size() == arr.length) {
            // 可以搜集结果 这里就仅打印看看效果
            System.out.println(track);
            return;
        }
        int prevNum = -999;// 题目范围之外随便一个数字
        for (int i = 0; i < arr.length; i++) {
            // 可选择的是在路径中未出现过的
            if (used[i]) continue;
            if (i > 0 && arr[i] == arr[i - 1] && !used[i]) continue;
            track.add(arr[i]);// 做选择
            used[i] = true; // 记录下标

            backtrack(arr, track, used);
            used[i] = false;
            track.removeLast();// 取消选择
        }
    }


    // 全排列【元素重复不可复选】其他方法
    public static void backtrack2(int[] arr, LinkedList<Integer> track, boolean[] used) {
        if (track.size() == arr.length) {
            // 可以搜集结果 这里就仅打印看看效果
            System.out.println(track);
            return;
        }
        int prevNum = -999;// 题目范围之外随便一个数字
        for (int i = 0; i < arr.length; i++) {
            // 可选择的是在路径中未出现过的
            if (used[i]) continue;
            if (prevNum == arr[i]) continue;
            track.add(arr[i]);// 做选择
            used[i] = true; // 记录下标
            prevNum = arr[i];// 同层重复的才解决 这样恰好非常符合
            backtrack(arr, track, used);
            used[i] = false;
            track.removeLast();// 取消选择
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[arr.length];
        backtrack(arr, track, used);
    }
}
