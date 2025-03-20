package com.algorithm.hot100;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hac
 * @date 2024/7/24 15:35
 */
public class T101 {
    public static void main(String[] args) {
        Queue<Integer> list = new LinkedList<>();
        list.offer(1);
        list.offer(2);
        System.out.println(list.poll());

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.poll());
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(u);
        queue.offer(v);
        while (!queue.isEmpty()) {
            u = queue.poll();
            v = queue.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }
            // 按照对称的方式将节点添加到队列中的。如果顺序错误，就无法正确地比较对称位置的节点。
            queue.offer(u.left);
            queue.offer(v.right);

            queue.offer(u.right);
            queue.offer(v.left);
        }
        return true;
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true; // 如果两个子节点都为空，互为镜像
        if (t1 == null || t2 == null) return false; // 如果其中一个为空，另一个不为空，不互为镜像
        return (t1.val == t2.val) // 两个节点的值相等
                && isMirror(t1.right, t2.left) // 递归检查 t1 的右子树和 t2 的左子树是否互为镜像
                && isMirror(t1.left, t2.right); // 递归检查 t1 的左子树和 t2 的右子树是否互为镜像
    }

}
