package com.algorithm.basic.search.binary_search;

/**
 * @author hac
 * @date 2025/4/6 15:05
 */
public class BinarySearch1 {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            // 防止溢出
            int mid = left + (right - left) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 8, 13};
        int target = 6;
        System.out.println(binarySearch(arr, target));
    }
}
