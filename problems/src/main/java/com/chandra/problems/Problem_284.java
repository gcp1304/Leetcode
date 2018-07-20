package com.chandra.problems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 284. Peeking Iterator
 * <p>
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().
 * Here is an example. Assume that the iterator is initialized to the beginning of the queue: [1, 2, 3].
 * Call next() gets you 1, the first element in the queue.
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.
 * Follow up: How would you extend your design to be generic and work with all types, not just integer?
 */

public class Problem_284 {

    public static class Solution {
        class PeekingIterator implements Iterator<Integer> {

            Queue<Integer> queue;

            public PeekingIterator(Iterator<Integer> iterator) {
                // initialize any member here.
                queue = new LinkedList<>();
                while (iterator.hasNext()) queue.offer(iterator.next());
            }

            // Returns the next element in the iteration without advancing the iterator.
            public Integer peek() {
                return queue.peek();
            }

            // hasNext() and next() should behave the same as in the Iterator interface.
            // Override them if needed.
            @Override
            public Integer next() {
                return queue.poll();
            }

            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }
        }
    }

    public static class Solution_1 {
        class PeekingIterator implements Iterator<Integer> {

            Iterator<Integer> iterator;
            Integer next = null;

            public PeekingIterator(Iterator<Integer> iterator) {
                // initialize any member here.
                this.iterator = iterator;
                if (iterator.hasNext()) next = iterator.next();
            }

            // Returns the next element in the iteration without advancing the iterator.
            public Integer peek() {
                return next;
            }

            // hasNext() and next() should behave the same as in the Iterator interface.
            // Override them if needed.
            @Override
            public Integer next() {
                int temp = next;
                next = (iterator.hasNext()) ? iterator.next() : null;
                return temp;
            }

            @Override
            public boolean hasNext() {
                return next != null;
            }
        }
    }
}
