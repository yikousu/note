package com.algorithm.hot100;

import java.util.HashSet;

/**
 * @author hac
 * @date 2024/7/9 20:45
 */
public class T142 {
    // T141基础上改一下即可
    public ListNode detectCycle(ListNode head) {
        ListNode res = new ListNode();
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
