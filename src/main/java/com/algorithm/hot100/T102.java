package com.algorithm.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hac
 * @date 2024/8/22 16:49
 */
public class T102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                temp.add(node.val);
            }
            res.add(temp);
        }
        return res;
    }

    // me
    public static List<List<Integer>> levelOrder1(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int[] levelNodeCount = new int[2000]; // 表示每一层的个数
        int cnt = 0;
        levelNodeCount[cnt] = 1;// 第一层
        while (!queue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            cnt += 1;
            int index = cnt;
            levelNodeCount[index] = 0;
            for (int i = 0; i < levelNodeCount[cnt - 1]; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    levelNodeCount[index] += 1;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    levelNodeCount[index] += 1;
                }
                temp.add(node.val);
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(levelOrder(root));


    }
}
