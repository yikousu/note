package com.algorithm.hot100;

import java.util.ArrayList;

/**
 * @author hac
 * @date 2024/7/7 22:38
 */
public class T234 {
    public static boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i) != list.get(list.size() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
