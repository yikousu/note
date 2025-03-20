package com.algorithm.hot100;

/**
 * @author hac
 * @date 2024/8/22 16:26
 */
public class T543 {
    private int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return res;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = depth(node.left);
        int right = depth(node.right);

        // 计算经过当前节点的直径
        res = Math.max(res, left + right);

        // 返回当前节点的深度
        return Math.max(left, right) + 1;
    }


    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }


}
