package com.algorithm.hot100;

import java.util.ArrayList;

/**
 * @author hac
 * @date 2024/7/9 20:46
 */
public class T21 {
    public static ListNode mergeTwoListsMe(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                list.add(list2.val);
                list2 = list2.next;
            } else {
                list.add(list1.val);
                list1 = list1.next;
            }
        }

        while (list1 != null) {
            list.add(list1.val);
            list1 = list1.next;
        }
        while (list2 != null) {
            list.add(list2.val);
            list2 = list2.next;
        }
        ListNode node = new ListNode();
        ListNode res = new ListNode();
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                node.val = list.get(i);
                res = node;
            } else {
                ListNode temp = new ListNode(list.get(i));
                node.next = temp;

                node = temp;
            }
        }

        return res;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(0);
        ListNode temp = res;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        temp.next = list1 == null ? list2 : list1;
        return res.next;
    }

    public static void main(String[] args) {

    }
}
