package com.chandra.problems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
 *
 * Example:
 *
 * LRUCache cache = new LRUCache(2);//capacity
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */

public class Problem_146 {

    public static class Solution1 {
        public class LRUCache {
            /**
             * The shortest implementation is to use LinkedHashMap:
             * specify a size of the linkedHashMap;
             * override the removeEldestEntry method when its size exceeds max size:
             * https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html#removeEldestEntry-java.util.Map.Entry-
             * in the constructor, set the last boolean variable to be true: it means the ordering mode,
             * if we set it to be true, it means in access order, false, means it's in insertion order:
             * https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html#LinkedHashMap-int-float-boolean-
             */

            private Map<Integer, Integer> cache;

            public LRUCache(int capacity) {
                cache = new LinkedHashMap<Integer, Integer>(capacity, 1.0f, true) {
                    public boolean removeEldestEntry(Map.Entry eldest) {
                        return cache.size() > capacity;
                    }
                };
            }

            public int get(int key) {
                return cache.getOrDefault(key, -1);
            }

            public void set(int key, int value) {
                cache.put(key, value);
            }
        }
    }

    public static class Solution2 {
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
}
