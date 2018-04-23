package com.chandra.problems;

import com.chandra.common.ListNode;

public class Problem_206 {
    public static class Solution1 {

        // In-place iterative solution with O(1) space
        // Since we are not creating new nodes, just creating an extra variables which live in stack during the execution.
        // Once the execution is done all the variables are cleared from stack, hence no extra space is being used.
        public ListNode reverseList(ListNode head) {

            ListNode newHead = null;

            while (head != null) {
                // save next node link
                ListNode nextNode = head.next;
                // link new head to current node
                head.next = newHead;
                // move new head to current node
                newHead = head;
                // move head to next node to continue
                head = nextNode;
            }

            return newHead;
        }
    }

    public static class Solution2 {
        // Recursive solution
        public ListNode reverseList(ListNode head) {
            return reverseList(head, null);
        }

        private ListNode reverseList(ListNode head, ListNode newHead) {
            if (head == null) return newHead;

            ListNode nextNode = head.next;
            head.next = newHead;
            return reverseList(nextNode, head);
        }
    }
}
