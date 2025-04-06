package com.algorithm.basic.search.binary_search;

/**
 * 时间复杂度是 O(log n)，远优于遍历
 *
 * @author hac
 * @date 2025/4/6 15:32
 */
public class TargetCount {
    public static int countOccurrences(int[] arr, int target) {
        int left = findFirst(arr, target);
        int right = findLast(arr, target);
        if (left == -1 || right == -1) {
            return 0;
        }
        return right - left + 1;
    }

    public static int findFirst(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        int result = -1;
        while (left <= right) {
            // 防止溢出
            int mid = left + (right - left) / 2;
            if (target == arr[mid]) {
                result = mid;
                right = mid - 1;  // 继续往左边找
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static int findLast(int[] arr, int target) {
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
        int[] arr = {1, 2, 2, 2, 2, 3, 5, 6};
        int target = 2;
        System.out.println(countOccurrences(arr, target));
    }
}
