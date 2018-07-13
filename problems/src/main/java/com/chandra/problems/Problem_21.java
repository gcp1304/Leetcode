package com.chandra.problems;


import com.chandra.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 21. Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

 Example:

 Input: 1->2->4, 1->3->4
 Output: 1->1->2->3->4->4
 */
public class Problem_21 {
    public static class Solution_1 {
        // Iterative solution
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;

            if (l2 == null) return l1;

            ListNode res = new ListNode(-1);
            ListNode cur = res;

            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }

            if (l1.next != null) {
                cur.next = l1;
            }

            if (l2.next != null) {
                cur.next = l2;
            }

            return res.next;
        }
    }

    public static class Solution_2 {
        // Recursive solution
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;

            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }

        }
    }
}
