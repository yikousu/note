package com.algorithm.hot100;

/**
 * @author hac
 * @date 2024/8/24 11:26
 */
public class T225_76 {
    // 堆化一个子树，调整为最大堆
    private static void heapify(int[] array, int n, int i) {
        int root = i; // 当前子树的根节点
        int left = 2 * i + 1; // 左子节点
        int right = 2 * i + 2; // 右子节点
        // 根节点的值与两个子节点较大值进行交换
        if (left < n && array[left] > array[root]) {
            root = left;
        }
        if (right < n && array[right] > array[root]) {
            root = right;
        }

        // 如果最大值不是根节点，交换，并递归调整
        if (root != i) {
            swap(array, i, root);
            heapify(array, n, root);// 因为根节点变化了 需要以新根节点继续遍历
        }
    }

    // 交换数组中的两个元素
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int findKthLargest(int[] array, int k) {
        // 0 1 2 3 4   k = 2
        // 第k大的元素 n-k
        // 构建最大堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }

        // 逐步将最大元素移到末尾，缩小堆的大小，继续堆化
        for (int i = array.length - 1; i >= array.length - k; i--) {
            // 将当前根（最大）移动到数组的末尾
            swap(array, 0, i);

            // 调整堆结构
            heapify(array, i, 0);
        }
        return array[0];

    }
}
