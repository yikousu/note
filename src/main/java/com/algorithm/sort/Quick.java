package com.algorithm.sort;

import java.util.Arrays;


public class Quick {
    public static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    // 快排 两个指针 ①遍历  ②慢指针实现小于基准元素的都在左边
    public static void quickSort(int[] arr, int l, int h) {
        if (!(l < h)) {
            return;
        }
        int mid = partition(arr, l, h);
        quickSort(arr, l, mid - 1);
        quickSort(arr, mid, h);
    }

    public static int partition(int[] arr, int l, int h) {
        int pivot = arr[h];
        int i = l - 1;// 记录左边序列小于基准的有序索引
        for (int j = l; j < h; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        // h其实就是i后面个位置是基准元素的新位置  但是基准元素下标是h
        swap(arr, i + 1, h);
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
