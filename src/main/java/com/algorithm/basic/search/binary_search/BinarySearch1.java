package com.algorithm.basic.search.binary_search;

/**
 * @author hac
 * @date 2025/4/6 15:05
 */

/*
流程：
初始：
left = 0
right = 数组长度 - 1

循环：
1. 取中间位置 mid = (left + right) / 2
2. 判断 nums[mid] 和 target 的关系：
   - 相等：返回 mid
   - 小于：目标在右边 → left = mid + 1
   - 大于：目标在左边 → right = mid - 1
3. 如果 left > right，说明没找到，返回 -1
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
