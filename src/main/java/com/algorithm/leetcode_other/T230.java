package com.algorithm.leetcode_other;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hac
 * @date 2024/9/9 19:26
 */
public class T230 {

    // // 中序遍历 左根右
    // public int kthSmallest(TreeNode root, int k) {
    //     if (root == null) return 0;
    //     int res = 0;
    //     int count = 0;
    //     Stack<TreeNode> stack = new Stack<>();
    //     while (root != null || !stack.isEmpty()) {
    //         while (root != null) {
    //             stack.push(root);
    //             root = root.left;
    //         }
    //         root = stack.pop();
    //         count += 1;
    //         if (count == k) {
    //             res = root.val;
    //             break;
    //         }
    //         root = root.right;
    //     }
    //     return res;
    // }
    //
    // public int kthSmallest1(TreeNode root, int k) {
    //     if (root == null) return 0;
    //     ArrayList<Integer> list = new ArrayList<>();
    //     // 层次遍历取出值
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(root);
    //     while (!queue.isEmpty()) {
    //         TreeNode root = queue.poll();
    //         list.add(root.val);
    //         if (root.left != null) queue.offer(root.left);
    //         if (root.right != null) queue.offer(root.right);
    //     }
    //     // 二叉搜索树中第 K 小的元素
    //     PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    //     for (Integer i : list) {
    //         maxHeap.offer(i);
    //         if (maxHeap.size() > k) {
    //             maxHeap.poll();
    //         }
    //     }
    //     return maxHeap.peek();
    // }


    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int[] list = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        for (Integer i : list) {
            maxHeap.offer(i);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        System.out.println(maxHeap.peek());
    }

}
