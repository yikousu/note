package com.algorithm.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hac
 * @date 2024/7/24 11:40
 */
public class T148 {
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        list.sort((o1, o2) -> o1 - o2);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (Integer i : list) {
            // 插入新节点
            ListNode node = new ListNode(i);
            cur.next = node;
            cur = node;
        }
        return dummy.next;
    }
}



