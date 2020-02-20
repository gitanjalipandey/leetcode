package com.leetcode.linkedlist;

import com.leetcode.common.ListNode;

// https://leetcode.com/problems/sort-list/

public class SortLinkedList {
    public ListNode sortList(ListNode head) {

        ListNode dummy = new ListNode(0);
        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        ListNode merged = merge(l1, fast);
        return merged;


    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(0);
        ListNode head = newNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                newNode.next = new ListNode(l1.val);
                newNode = newNode.next;
                l1 = l1.next;
            } else {
                newNode.next = new ListNode(l2.val);
                newNode = newNode.next;
                l2 = l2.next;
            }

        }
        if (l1 != null) {
            newNode.next = l1;
        } else {
            newNode.next = l2;
        }
        return head.next;
    }
}
