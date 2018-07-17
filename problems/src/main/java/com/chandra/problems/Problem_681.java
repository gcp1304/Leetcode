package com.chandra.problems;

import java.util.HashSet;

/**
 * 681. Next Closest Time
 *
 * Given a time represented in the format "HH:MM",
 * form the next closest time by reusing the current digits.
 * There is no limit on how many times a digit can be reused.
 * You may assume the given input string is always valid.
 * For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.
 Example 1:
 Input: "19:34"
 Output: "19:39"
 Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39,
 which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.
 Example 2:
 Input: "23:59"
 Output: "22:22"
 Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22.
 It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
 */
public class Problem_681 {
    public static class Solution_1 {
        public static String nextClosestTime(String time) {
            String result = "";

            // Step 1: Store the original digits from the input time.
            // we use hashset so that we can store only unique digits
            HashSet<Integer> allowedDigits = new HashSet<>();
            for (int i = 0; i < time.length(); i++) {
                char c = time.charAt(i);
                if (c == ':') continue; // since input time has : we skip it
                allowedDigits.add(c - '0');
            }

            // Step 2: Convert input time into minutes
            // convert hour to minutes
            int originalMinutes = Integer.parseInt(time.substring(0, 2)) * 60;
            originalMinutes += Integer.parseInt(time.substring(3));

            // Step 3: Keep incrementing originalMinutes by 1 and convert that to time format HHMM and check the digits
            // that formed new time are from the original digits, if not then continue incrementing
            int curMinutes = originalMinutes;
            while (true) {
                // Step 3a : Increment original minutes by 1 and determine the digits that form HHMM
                curMinutes = (curMinutes + 1) % (24*60); // new time should be less that 24 hour minutes hence %
                int[] currentDigits = new int[]{ // HHMM
                        curMinutes/60/10, // First H, hence / 10 to grab first digit
                        curMinutes/60%10, // Second H, hence % 10 to grab second digit
                        curMinutes%60/10, // First M, hence / 10 to grab first digit
                        curMinutes%60%10  // Second M, hence % 10 to grab second digit
                };

                // Step 3b: Check if the new digits are combination of origina digits
                    // True -> return it as result
                    // False -> continue with next combination
                search: {
                    for (int digit : currentDigits) {
                        // if we encounter a digits that's not present in original combination then we break to continue with
                        // next combination to save time
                        if (!allowedDigits.contains(digit)) break search;
                    }
                    // current time digits are combination of original time digits, return the new time
                    return String.format("%02d:%02d", curMinutes/60, curMinutes%60);
                }
            }
        }

        public static void main(String[] args) {
            System.out.println(Problem_681.Solution_1.nextClosestTime("19:34"));
            System.out.println(Problem_681.Solution_1.nextClosestTime("23:59"));
        }
    }
}
