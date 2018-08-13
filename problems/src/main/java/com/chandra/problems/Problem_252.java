package com.chandra.problems;

import com.chandra.common.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 252 Meeting Rooms
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 *
 *  For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return false.
 */

public class Problem_252 {
    public static class Solution1 {
        public static boolean canAttendMeetings(Interval[] intervals) {
            Arrays.sort(intervals, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    return o1.start - o2.start;
                }
            });

            for (int i = 0; i < intervals.length - 1; i++) {
                if (intervals[i].end > intervals[i+1].start) return false;
            }
            return true;
        }

        public static void main(String[] args) {
            Interval[] intervals = new Interval[3];
            Interval zero = new Interval();
            zero.start = 0;
            zero.end = 30;
            intervals[0] = zero;

            Interval one = new Interval();
            one.start = 5;
            one.end = 10;
            intervals[1] = one;

            Interval two = new Interval();
            two.start = 15;
            two.end = 20;
            intervals[2] = two;

            System.out.println(canAttendMeetings(intervals));
        }
    }
}
