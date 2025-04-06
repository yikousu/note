package com.algorithm.basic.sort;

/**
 * @author hac
 * @date 2025/4/6 15:52
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    /**
     * 加个优化标志位（如没发生交换，提前结束）可以提升效率
     * @param arr
     */
    public static void bubbleSort2(int[] arr) {
        boolean swapped = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swapped = true;
                    swap(arr, j, j - 1);
                }
            }
            // 如果某一轮没有发生交换，说明数组已经有序，可以提前结束
            if (!swapped) break;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 3, 7, 1};
        bubbleSort2(arr);
        for (int num : arr) {
            System.out.print(num + "\t");
        }
    }
}
