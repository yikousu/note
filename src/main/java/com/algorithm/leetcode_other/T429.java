package com.algorithm.leetcode_other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hac
 * @date 2024/8/29 18:44
 */
public class T429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (size > 0) {
                Node node = queue.poll();
                list.add(node.val);
                for (Node child : node.children) {
                    queue.offer(child);
                }
                size--;
            }
            res.add(list);
        }
        return res;
    }
}
