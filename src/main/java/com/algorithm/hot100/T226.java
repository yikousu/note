package com.algorithm.hot100;

import java.util.LinkedList;

/**
 * @author hac
 * @date 2024/7/24 15:13
 */
public class T226 {
    // 翻转二叉树
    // 我们从根节点开始，递归地对树进行遍历，并从叶子节点先开始翻转
    // 如果当前遍历到的节点 root 的左右两棵子树都已经翻转，那么我们只需要交换两棵子树的位置
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree1(root.left);
        TreeNode right = invertTree1(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // 逐层向下翻转
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) queue.push(node.left);
            if (node.right != null) queue.push(node.right);
        }
        return root;
    }
}
