package com.chandra.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 170. Two Sum III - Data structure design
 *
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 *
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 *
 * Example 1:
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 *
 * Example 2:
 * add(3); add(1); add(2);
 * find(3) -> true
 * find(6) -> false
 */

public class Problem_170 {

    /*
    add - O(1) runtime, find - O(n) runtime
    To find if a pair sum exists, just iterate through the hash table in O(n) runtime along with handling duplicates.
     */

    public static class Solution_1 {
        public class TwoSum {
            private Map<Integer, Integer> table = new HashMap<>();

            public void add(int input) {
                table.put(input, table.getOrDefault(input, 0)+1);
            }

            public boolean find(int val) {
                for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
                    int num = entry.getKey();
                    int y = val - num;

                    if (y == num) {
                        // For duplicates, ensure there are at least two individual numbers.
                        if (entry.getValue() >= 2) return true;
                    } else if (table.containsKey(y)) {
                        return true;
                    }
                }

                return false;
            }
        }
    }
}
