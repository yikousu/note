package com.algorithm.hot100;

/**
 * @author hac
 * @date 2024/7/24 14:54
 */
public class T104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
