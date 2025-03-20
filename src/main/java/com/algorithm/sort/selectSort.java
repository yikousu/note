package com.algorithm.sort;

import java.util.Arrays;

// 选择排序
public class selectSort {
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
