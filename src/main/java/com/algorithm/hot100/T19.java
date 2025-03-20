package com.algorithm.hot100;

import java.util.ArrayList;

/**
 * @author hac
 * @date 2024/7/11 20:44
 */
public class T19 {
    // me
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        list.remove(list.size() - n);
        ListNode res = new ListNode();
        ListNode temp = res;
        for (Integer i : list) {
            ListNode node = new ListNode();
            node.val = i;
            temp.next = node;
            temp = temp.next;
        }
        return res.next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        for (int i = 0; i < getLength(head) - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    public static int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public static void main(String[] args) {


    }
}
