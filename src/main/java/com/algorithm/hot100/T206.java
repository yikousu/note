package com.algorithm.hot100;

/**
 * @author hac
 * @date 2024/7/6 22:17
 */
public class T206 {
    public static ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode root = new ListNode(666);
        ListNode res = new ListNode(head.val);
        root.next = res;
        head = head.next;
        while (head != null) {

            ListNode temp = new ListNode(head.val);
            temp.next = root.next;
            root.next = temp;

            head = head.next;
        }
        return root.next;

    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode root = null;
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            temp.next = root;
            root = temp;
            head = head.next;
        }
        return root;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode root = null;
        while (head != null) {
            ListNode tmp = head.next; // 暂存后继节点 cur.next
            head.next = root;          // 修改 next 引用指向
            root = head;               // pre 暂存 cur
            head = tmp;               // cur 访问下一节点
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);

        ListNode listNode = reverseList(listNode1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}