package com.chandra.problems;

import com.chandra.common.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 253 Meeting Rooms II
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 */
public class Problem_253 {
    public static class Solution_1 {
        // Using PQ
        public int minMeetingRooms(Interval[] intervals) {
            if (intervals == null || intervals.length == 0) return 0;

            // sort intervals by start time
            Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));

            // PQ with min heap to store the end times meeting with overlap schedule
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            // start with first meeting room
            pq.offer(intervals[0].end);


            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i].start >= pq.peek()) {
                    // if the current meeting starts right after
                    // there's no need for a new room hence remove the end time of previous meeting
                    pq.poll();
                }

                // add the new end time
                pq.offer(intervals[i].end);
            }
            return pq.size();
        }
    }


    public static class Solution_2 {
        // Greedy Solution
        public int minMeetingRooms(Interval[] intervals) {
            int[] start = new int[intervals.length];
            int[] end = new int[intervals.length];

            for (int i = 0; i < intervals.length; i++) {
                start[i] = intervals[i].start;
                end[i] = intervals[i].end;
            }

            Arrays.sort(start);
            Arrays.sort(end);

            int endIdx = 0, res = 0;

            for (int i = 0; i < start.length; i++) {
                if (start[i] < end[endIdx]) res++;
                else endIdx++;
            }
            return res;
        }
    }
}
