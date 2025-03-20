package com.algorithm.hot100;

/**
 * @author hac
 * @date 2024/7/9 22:45
 */
public class T2 {
    public static ListNode reverseListNode(ListNode head) {
        ListNode res = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = res;
            res = head;
            head = temp;
        }
        return res;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (l1 != null || l2 != null) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;

            temp.next = new ListNode(sum % 10);
            temp = temp.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public static ListNode addTwoNumbersMe(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode temp = res;
        while (l1 != null && l2 != null) {
            int currentVal = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            ListNode currentNode = new ListNode(currentVal);
            temp.next = currentNode;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode residual = l1 == null ? l2 : l1;
        while (residual != null) {
            int currentVal = (residual.val + carry) % 10;
            carry = (residual.val + carry) / 10;
            ListNode currentNode = new ListNode(currentVal);
            temp.next = currentNode;
            temp = temp.next;
            residual = residual.next;
        }

        if (carry != 0) {
            ListNode currentNode = new ListNode(carry);
            temp.next = currentNode;
        }
        return res.next;

    }

    public static void main(String[] args) {

    }
}
