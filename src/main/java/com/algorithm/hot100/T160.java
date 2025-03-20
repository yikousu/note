// package com.hac.hot100;
//
///**
// * @author hac
// * @date 2024/7/5 21:01
// */
// public class T160 {
//    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
//        ListNode she = headA;
//        ListNode he = headB;
//        // 直到两人相遇
//        while (she != he) {
//            if (she != null) {
//                she = she.next;// 如果她没走到尽头就一直走下去
//            } else {
//                she = headB;// 直到尽头也没遇见他，所以她去往他走过的路
//            }
//            if (he != null) {
//                he = he.next;
//            } else {
//                he = headA;
//            }
//        }
//        return he;// 返回两人第一次相遇的地方
//    }
//
//    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode p1 = headA;
//        ListNode p2 = headB;
//        while (p1 != p2) {
//            p1 = p1 == null ? headB : p1.next;
//            p2 = p2 == null ? headA : p2.next;
//        }
//        return p1;
//    }
//
//    public static void main(String[] args) {
//
//        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(8);
//        ListNode l3 = new ListNode(3);
//        l1.next = l2;
//        l2.next = l3;
//        ListNode l4 = new ListNode(0);
//        ListNode l5 = new ListNode(7);
//        ListNode l6 = new ListNode(4);
//        l4.next = l5;
//        l5.next = l6;
//        ListNode listNode = getIntersectionNode(l1, l4);
//        System.out.println(listNode);
//    }
//
//}
//
// class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }
//}