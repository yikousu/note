package com.algorithm.leetcode_other;

import java.util.HashSet;

/**
 * @author hac
 * @date 2024/8/29 21:20
 */
public class T671 {

    public static int findSecondMinimumValue1(TreeNode root) {
        HashSet<Integer> set = new HashSet<>();
        helper(root, set);
        if (set.size() < 2) return -1;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i : set) {
            if (i < min1) {
                min1 = i;
            }
        }
        set.remove(min1);
        for (int i : set) {
            if (i < min2) {
                min2 = i;
            }
        }
        return min2;
    }

    public static void helper(TreeNode root, HashSet<Integer> set) {
        if (root == null) return;
        set.add(root.val);
        helper(root.left, set);
        helper(root.right, set);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(findSecondMinimumValue(root));

    }


    public static int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        // 初始最小值为根节点的值
        int firstMin = root.val;
        // 使用递归找出第二小的值
        return findSecondMinimum(root, firstMin);
    }

    private static int findSecondMinimum(TreeNode root, int firstMin) {
        if (root == null) return -1;
        // 如果当前节点值大于最小值，可能是第二小的值
        if (root.val > firstMin) return root.val;

        // 递归查找左右子树中的第二小值
        int left = findSecondMinimum(root.left, firstMin);
        int right = findSecondMinimum(root.right, firstMin);

        // 处理左右子树的值
        if (left != -1 && right != -1) {
            return Math.min(left, right);
        }
        return Math.max(left, right);
    }


}
