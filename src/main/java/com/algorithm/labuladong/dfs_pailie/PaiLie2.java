package com.algorithm.labuladong.dfs_pailie;

import java.util.LinkedList;

public class PaiLie2 {
    public static void backtrack(int[] arr, LinkedList<Integer> track) {

        if (track.size() == arr.length) {
            // 可以搜集结果 这里就仅打印看看效果
            System.out.println(track);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            // 可选择的是在路径中未出现过的

            track.add(arr[i]);// 做选择
            backtrack(arr, track);
            track.removeLast();// 取消选择
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(arr, track);
    }
}
