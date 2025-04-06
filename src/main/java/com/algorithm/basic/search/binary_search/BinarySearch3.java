package com.algorithm.basic.search.binary_search;

/**
 * @author hac
 * @date 2025/4/6 15:19
 */
public class BinarySearch3 {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        int result = -1;
        while (left <= right) {
            // 防止溢出
            int mid = left + (right - left) / 2;
            if (target == arr[mid]) {
                result = mid;
                left = mid + 1;// 继续往右边找
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3};
        int target = 2;
        System.out.println(binarySearch(arr, target));
    }
}
