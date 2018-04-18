package com.chandra.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 *
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * */

public class Problem_13 {

    public static class Solution1 {
        public int romanToInt(String s) {
            int result = 0;
            if (s == null || s.length() == 0) return result;

            HashMap<Character, Integer> map = new HashMap<>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);

            result += map.get(s.charAt(0));
            for (int i=1;i<s.length();i++) {
                int val = map.get(s.charAt(i));
                if (val > map.get(s.charAt(i-1))) {
                    //A smaller number in front of a larger number means subtraction,
                    // all else means addition. For example, IV means 4, VI means 6.
                    // subtract previous char value
                    val -= map.get(s.charAt(i-1));
                    // remove the previous char value from result
                    result -= map.get(s.charAt(i-1));
                }
                // add the new computed val to result
                result += val;

            }
            return result;
        }

    }

    public static class Solution2 {
        public int romanToInt(String s) {
            int result = 0;
            if (s == null || s.length() == 0) return result;

            HashMap<Character, Integer> map = new HashMap<>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);

            result = map.get(s.charAt(s.length()-1));

            // scan from last but one
            for (int i=s.length()-2;i>=0;i--) {
                if (map.get(s.charAt(i)) >= map.get(s.charAt(i+1))) {
                    // add if current element is > next element
                    result += map.get(s.charAt(i));
                } else {
                    // subtract if current element is < next element
                    result -= map.get(s.charAt(i));
                }
            }
            return result;
        }
    }

    public static class Solution3 {
        public int romanToInt(String s) {
            Map<Character, Integer> map = new HashMap<>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);

            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                if (i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                    result += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
                } else {
                    result += map.get(s.charAt(i));
                }
            }
            return result;
        }
    }

}
