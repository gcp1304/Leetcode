package com.chandra.problems;

import com.chandra.common.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. Insert Interval
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:

 Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 Output: [[1,5],[6,9]]
 Example 2:

 Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 Output: [[1,2],[3,10],[12,16]]
 Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

 */

public class Problem_57 {
    public static class Solution_1 {
        // without using extra space
        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            int i = 0;
            while (i < intervals.size() && intervals.get(i).end < newInterval.start) i++;

            while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
                intervals.remove(i);
            }
            intervals.add(i, newInterval);

            return intervals;
        }
    }

    public static class Solution_2 {
        // with extra space
        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            int i = 0;
            List<Interval> res = new ArrayList<>();
            while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
                res.add(intervals.get(i++));
            }

            while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
                i++;
            }

            res.add(newInterval);

            while (i < intervals.size()) {
                res.add(intervals.get(i++));
            }

            return res;

        }
    }
}
