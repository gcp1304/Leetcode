package com.chandra.problems;

import java.util.Collections;
import java.util.PriorityQueue;


/**
 * 295. Find Median from Data Stream
 *
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

 For example,
 [2,3,4], the median is 3

 [2,3], the median is (2 + 3) / 2 = 2.5

 Design a data structure that supports the following two operations:

 void addNum(int num) - Add a integer number from the data stream to the data structure.
 double findMedian() - Return the median of all elements so far.
 Example:

 addNum(1)
 addNum(2)
 findMedian() -> 1.5
 addNum(3)
 findMedian() -> 2
 */
public class Problem_295 {
    /*
     *
     * 1. always keep one queue one element more than the other if the number is odd, offer into that one
     * first, then poll from that queue and offer into the other queue, then check whether that queue is smaller
     * in size than the other, if so, poll one from the other queue and offer it into this queue
     *
     * 2. only need to check whether this bigger queue size is greater than the other queue when returning.
     */
    public static class Solution_1 {
        class MedianFinder {

            PriorityQueue<Integer> minHeap;
            PriorityQueue<Integer> maxHeap;

            /** initialize your data structure here. */
            public MedianFinder() {
                minHeap = new PriorityQueue<>();
                maxHeap = new PriorityQueue<>(Collections.reverseOrder());

                // other way to initialize max heap is
                //maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

            }

            public void addNum(int num) {
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
                if (minHeap.size() < maxHeap.size()) {
                    minHeap.offer(maxHeap.poll());
                }
            }

            public double findMedian() {
                return minHeap.size() > maxHeap.size() ? minHeap.peek() : (minHeap.peek() + maxHeap.peek()) / 2.0;
            }
        }
    }
}
