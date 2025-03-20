package com.algorithm.hot100;

/**
 * @author hac
 * @date 2024/7/23 22:06
 */
public class T24 {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;

            first.next = second.next;
            second.next = first;
            cur.next = second;

            cur = first;
        }
        return dummy.next;
    }


    public static void main(String[] args) {

    }
}
