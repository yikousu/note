package com.algorithm.leetcode_other;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hac
 * @date 2024/8/29 17:23
 */
public class T559 {
    public int maxDepth1(Node root) {
        if (root == null) return 0;
        int res = 0;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            res += 1;
            int size = queue.size();
            while (size > 0) {
                Node node = queue.poll();
                queue.addAll(node.children);
                size--;
            }
        }
        return res;
    }

    public int maxDepth(Node root) {
        if (root == null) return 0;
        int maxDepth = 0;
        for (Node child : root.children) {
            int childDepth = maxDepth(child);
            maxDepth = Math.max(childDepth, maxDepth);
        }
        return maxDepth + 1;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};