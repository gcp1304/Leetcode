package com.chandra.problems;

import com.chandra.common.RandomListNode;

import java.util.HashMap;
import java.util.Map;


/**
 * 138. Copy List with Random Pointer
 *
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * */


public class Problem_138 {
    public static class Solution_1 {
        //hashmap + 2 iteration
        public RandomListNode copyRandomList(RandomListNode head) {
            Map<RandomListNode, RandomListNode> map = new HashMap<>();
            RandomListNode node = head;
            while (node != null) {
                map.put(node, new RandomListNode(node.label));
                node = node.next;
            }

            node = head;
            while (node != null) {
                map.get(node).next = map.get(node.next);
                map.get(node).random = map.get(node.random);
                node = node.next;
            }

            return map.get(head);
        }
    }

    public static class Solution_2 {
        //hashmap + 2 iteration
        public RandomListNode copyRandomList(RandomListNode head) {
            RandomListNode dummy = new RandomListNode(0), curr = dummy;
            Map<RandomListNode, RandomListNode> map = new HashMap<>();

            // First iteration just copy nodes

            while (head != null) {
                RandomListNode newNode = new RandomListNode(head.label);
                newNode.random = head.random;
                map.put(head, newNode);
                curr.next = newNode;
                curr = curr.next;
                head = head.next;
            }

            curr = dummy.next;
            while (curr != null) {
                if (curr.random != null) {
                    curr.random = map.get(curr.random);
                }
                curr = curr.next;
            }

            return dummy.next;
        }
    }

    public static class Solution_3 {
        //hashmap + 1 iteration
        public RandomListNode copyRandomList(RandomListNode head) {
            RandomListNode dummy = new RandomListNode(0), curr = dummy;
            HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

            while (head != null) {
                RandomListNode node = null;
                if (map.containsKey(head)) {
                    node = map.get(head);
                } else {
                    node = new RandomListNode(head.label);
                    map.put(head, node);
                }

                if (head.random != null) {
                    if (map.containsKey(head.random)) {
                        node.random = map.get(head.random);
                    } else {
                        node.random = new RandomListNode(head.random.label);
                        map.put(head.random, node.random);
                    }
                }

                curr.next = node;
                curr = curr.next;
                head = head.next;
            }

            return dummy.next;
        }
    }
}
