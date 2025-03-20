package com.algorithm.leetcode_other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hac
 * @date 2024/8/29 18:40
 */
public class T590 {
    // 后续遍历   左右根
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        if (root == null) return;
        for (Node child : root.children) {
            helper(child, res);
        }
        res.add(root.val);
    }


}
