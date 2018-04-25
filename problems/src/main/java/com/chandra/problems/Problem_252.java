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
        public boolean canAttendMeetings(Interval[] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));

            for (int i = 0; i < intervals.length - 1; i++) {
                if (intervals[i].end > intervals[i+1].start) return false;
            }
            return true;
        }
    }
}
