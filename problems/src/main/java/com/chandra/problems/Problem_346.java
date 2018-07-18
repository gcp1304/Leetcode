package com.chandra.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 346. Moving Average from Data Stream
 *
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 For example,
 MovingAverage m = new MovingAverage(3);
 m.next(1) = 1
 m.next(10) = (1 + 10) / 2
 m.next(3) = (1 + 10 + 3) / 3
 m.next(5) = (10 + 3 + 5) / 3
 */
public class Problem_346 {

    public static class Solution {
        public static class MovingAverage {
            Queue<Integer> queue;
            int size;
            int sum;

            public MovingAverage(int size) {
                this.size = size;
                queue = new LinkedList<>();
                sum = 0;
            }

            public double next(int val) {
                queue.offer(val);
                sum += val;

                if (queue.size() > size) {
                    sum -= queue.poll();
                }

                return (double) sum / queue.size();
            }
        }
    }

    public static void main(String[] args) {
        Problem_346.Solution.MovingAverage m = new Solution.MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));

    }
}
