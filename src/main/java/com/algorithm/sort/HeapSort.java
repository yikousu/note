package com.algorithm.sort;

public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        // 构建大顶堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        // 堆排序
        int len = arr.length;
        while (len > 1) {
            // 理解成删除堆中一个元素  删堆顶元素 然后将最后一个元素放到堆顶 然后重新调整堆
            swap(arr, 0, len - 1); // 将堆顶元素与最后一个元素交换
            len--; // 因为数组后面的元素已经排序完成
            heapify(arr, 0, len); // 调整堆
        }
    }

    // 调整堆
    private static void heapify(int[] arr, int i, int len) {
        while (true) {
            int maxPos = i; // 假设当前节点是最大值
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            if (leftChild < len && arr[leftChild] > arr[maxPos]) {
                maxPos = leftChild; // 如果左子节点大于当前节点 更新最大值位置
            }
            if (rightChild < len && arr[rightChild] > arr[maxPos]) {
                maxPos = rightChild;
            }
            if (maxPos == i) break;
            swap(arr, i, maxPos);
            i = maxPos;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 主方法，用于测试堆排序
    public static void main(String[] args) {
        int[] arr = {6, 9, 1, 4, 5, 8, 7, 0, 2, 3};
        System.out.print("排序前: ");
        print(arr);
        heapSort(arr);
        System.out.print("排序后: ");
        print(arr);
    }

    // 打印数组
    public static void print(int[] arr) {
        if (arr == null) return;
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
