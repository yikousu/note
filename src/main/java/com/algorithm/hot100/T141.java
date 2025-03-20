package com.algorithm.hot100;

import java.util.HashSet;

/**
 * @author hac
 * @date 2024/7/9 20:06
 */
public class T141 {
    public static boolean hasCycle(ListNode head) {
        // set 中存储的是链表节点的引用（即 ListNode 对象的引用）。因为 HashSet 使用的是对象的引用进行比较，所以如果两个节点是同一个节点（即内存地址相同）
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(1));
        System.out.println(hasCycle(node));
    }
}
