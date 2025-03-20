package com.algorithm.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hac
 * @date 2024/7/24 11:52
 */
public class T94 {
    // 中序遍历 左中右
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        fun(root, list);
        return list;
    }

    public void fun(TreeNode root, List<Integer> list) {
        if (root == null) return;
        fun(root.left, list);
        list.add(root.val);
        fun(root.right, list);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            // 先把左侧节点全部入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 弹出栈顶节点，并添加到结果集中
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}
