package com.algorithm.basic.sort;

import java.util.Arrays;

// 插入排序
public class InsertSort {
    public static void InsertionSort(int[] arr) {
        // 新元素赋值给temp  然后依次比较  后裔一个【因为前面有序的  要给新元素留个位置】
        // while遍历有序的元素  插入新的元素
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            // temp不能换成arr[i] 因为当前位i会被替换
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = temp;
        }

    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        InsertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
