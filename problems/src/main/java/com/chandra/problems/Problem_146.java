package com.chandra.problems;

import java.util.HashMap;

/**
 * 146. LRU Cache
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 */

public class Problem_146 {

    private class Node {
        int key, value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }

    public class LRUCache {

        HashMap<Integer, Node> map;
        int capacity;
        Node head, tail;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            this.capacity = capacity;
            this.head = null;
            this.tail = null;
        }

        public int get(int key) {
            int value = -1;
            if (!map.containsKey(key)) return value;
            Node node = map.get(key);
            value = node.value;
            deleteNode(node);
            addNode(node);
            return value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                deleteNode(node);
                addNode(node);
            } else {
                Node node = new Node(key, value);
                map.put(key, node);
                addNode(node);
                if (map.size() > capacity) {
                    map.remove(tail.key);
                    deleteNode(tail);
                }
            }
        }

        private void addNode(Node node) {
            if (head == null && tail == null) {
                head = tail = node;
                return;
            }
            node.next = head;
            head.prev = node;
            node.prev = null;
            head = node;
        }

        private void deleteNode(Node node) {
            if (node == head && node == tail) {
                head = tail = null;
            } else if (node == head) {
                head = head.next;
            } else if (node == tail) {
                tail = tail.prev;
                tail.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }
    }
}
