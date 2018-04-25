package com.chandra.problems;

import com.chandra.common.ListNode;

/**
 * 25. Reverse Nodes in k-Group
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 */

public class Problem_25 {
    public static class Solution1 {
        // Iterative Solution

        /**
         * Reverse a link list between begin and end exclusively
         * an example:
         * a linked list:
         * 0->1->2->3->4->5->6
         * |           |
         * begin       end
         * after call begin = reverse(begin, end)
         * <p>
         * 0->3->2->1->4->5->6
         * |  |
         * begin end
         *
         * @return the reversed list's 'begin' node, which is the precedence of node end
         */
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null || k == 1) return head;

            ListNode dummyHead = new ListNode(999);
            dummyHead.next = head;

            ListNode start = dummyHead;
            int i = 0;
            while (head != null) {
                ++i;
                if (i % k != 0) {
                    head = head.next;
                } else {
                    start = reverse(start, head);
                    head = start.next;
                }
            }
            return dummyHead.next;
        }

        public ListNode reverse(ListNode start, ListNode end) {
            ListNode first = start.next;
            ListNode prev = start;
            ListNode next;
            ListNode curr = first;
            // Reversing the pointers
            while (curr != end) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            //moving the dummy head to beginning
            start.next = prev;

            // linking reversed tail to un-reversed list head
            first.next = curr;
            // returning reversed tail as the next boundary
            return first;

        }
    }

    public static class Solution2 {
        // Recursive Solution
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode cur = head, tmp = head, prev = null;
            for (int i = 0; i < k; i++, tmp = tmp.next)
                if (tmp == null) return head;  // check if there is enough k elements for reverse in current group
            for (int i = 0; i < k; i++) { // reverse k elements in current group
                tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
            }
            head.next = reverseKGroup(cur, k); // connect the real tail of current reversed group with the real head of remaining reversed group
            return prev; // return the real tail of current reversed group
        }
    }
}
