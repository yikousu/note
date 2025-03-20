package com.algorithm.leetcode_other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hac
 * @date 2024/8/29 18:22
 */
public class T589 {
    // 根左右

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(Node root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        for (Node child : root.children) {
            helper(child, res);
        }
    }


}
