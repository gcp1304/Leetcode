package com.chandra.problems;

import com.chandra.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.ToIntFunction;

/**
 * 23. Merge k Sorted Lists
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */

public class Problem_23 {
    public static class Solution1 {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;

            PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            });

            for (ListNode list : lists) {
                if (list != null) {
                    pq.add(list);
                }
            }

            if (pq.isEmpty()) return null;

            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;

            while (!pq.isEmpty()) {
                tail.next = pq.poll();
                tail = tail.next;

                if (tail.next != null)
                    pq.add(tail.next);
            }

            return dummy.next;
        }
    }
}
