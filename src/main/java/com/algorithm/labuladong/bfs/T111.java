package com.algorithm.labuladong.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class T111 {
    // BFS求二叉树的最小深度
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int deep = 1;// 因为根节点算一层
        while (!queue.isEmpty()) {// while控制一层一层往下走
            int size = queue.size();
            for (int i = 0; i < size; i++) {// for控制一层中依次遍历
                TreeNode cur = queue.poll();
                // 处理目标
                if (cur.left == null && cur.right == null) return deep;
                // 响相邻节点加入队列
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            deep++;
        }
        return deep;
    }

    // DFS求而车数最大深度【递归】
    public static int minDepthDfs(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int deep = Integer.MAX_VALUE;

        if (root.left != null) {
            deep = Math.min(deep, minDepthDfs(root.left));
        }
        if (root.right != null) {
            deep = Math.min(deep, minDepthDfs(root.right));
        }
        return deep + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(minDepthDfs(root));
    }
}
