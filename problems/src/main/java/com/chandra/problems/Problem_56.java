package com.chandra.problems;

import com.chandra.common.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 56. Merge Intervals
 *
 * Given a collection of intervals, merge all overlapping intervals.

 Example 1:

 Input: [[1,3],[2,6],[8,10],[15,18]]
 Output: [[1,6],[8,10],[15,18]]
 Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 Example 2:

 Input: [[1,4],[4,5]]
 Output: [[1,5]]
 Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 */
public class Problem_56 {
    public static class Solution_1 {
        public List<Interval> merge(List<Interval> intervals) {

            if (intervals.size() <= 1) {
                return intervals;
            }

            List<Interval> res = new ArrayList<>();
            intervals.sort(Comparator.comparingInt(interval -> interval.start));

            int start = intervals.get(0).start;
            int end = intervals.get(0).end;

            for (Interval interval : intervals) {
                if (interval.start <= end) {
                    end = Math.max(end, interval.end);
                } else {
                    res.add(new Interval(start, end));
                    start = interval.start;
                    end = interval.end;
                }
            }
            res.add(new Interval(start, end)); // add the last interval to result
            return res;

        }
    }
}
