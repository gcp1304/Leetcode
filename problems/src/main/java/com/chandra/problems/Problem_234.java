package com.chandra.problems;

import com.chandra.common.ListNode;

/**
 * 234. Palindrome Linked List
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class Problem_234 {

    // Time - O(n), Space - O(1)
    // Reverse second half and compare to check for palindrome
    public static class Solution1 {
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head, fast = head;

            // To find the mid point of the list
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // odd length list -> make right half smaller
            if (fast != null) slow = slow.next;

            // reverse the second half
            slow = reverse(slow);
            fast = head;

            // Compare both the half lists
            while (slow != null) {
                if (fast.val != slow.val) return false;

                fast = fast.next;
                slow = slow.next;
            }
            return true;
        }

        private ListNode reverse(ListNode head) {
            ListNode prev = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }

            return prev;
        }
    }
}
