package com.algorithm.basic.sort;


/**
 * @author hac
 * @date 2025/4/6 16:21
 */
/*
时间复杂度：O(n log n)

空间复杂度：O(n)，因为用到了辅助数组 temp[]

是否稳定：稳定排序（相同元素不会交换顺序）

适合大数据量排序，但空间消耗相对大
 */
/*
例子：
arr = [5, 2, 9, 1]

第一层：
→ mergeSort(arr, 0, 1) 排左边 [5, 2]
→ mergeSort(arr, 2, 3) 排右边 [9, 1]

第二层：
→ mergeSort(arr, 0, 0) → 一个元素 [5]，返回
→ mergeSort(arr, 1, 1) → 一个元素 [2]，返回
→ merge(arr, 0, 0, 1) → 合并为 [2, 5]

→ mergeSort(arr, 2, 2) → 一个元素 [9]，返回
→ mergeSort(arr, 3, 3) → 一个元素 [1]，返回
→ merge(arr, 2, 2, 3) → 合并为 [1, 9]

第三层：
→ merge(arr, 0, 1, 3) → 合并 [2, 5] 和 [1, 9] → 得到 [1, 2, 5, 9]


 */
public class MergeSort {

    // 两个mergeSort方法 ==> 方法重写

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    // 递归分治
    // 这是一个递归函数，它的目标是：把 arr[left...right] 这段排好序
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);        // 排左半部分
        mergeSort(arr, mid + 1, right);   // 排右半部分
        merge(arr, left, mid, right);     // 合并左右部分
    }

    // 合并两个有序子数组 [left, mid] 和 [mid+1, right]
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // 临时数组
        int i = left;     // 左半部分指针
        int j = mid + 1;  // 右半部分指针
        int k = 0;        // temp 数组指针

        // 比较左右部分，填入 temp
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 左边剩余
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // 右边剩余
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // 把 temp 内容复制回原数组
        for (int t = 0; t < temp.length; t++) {
            arr[left + t] = temp[t];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1};
        mergeSort(arr);

        System.out.print("排序结果：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
