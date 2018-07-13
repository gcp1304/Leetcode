package com.chandra.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. Substring with Concatenation of All Words
 *
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 For example, given:
 s: "barfoothefoobarman"
 words: ["foo", "bar"]
 You should return the indices: [0,9].
 (order does not matter).
 */

public class Problem_30 {
    // Sliding Window
    public static class Solution_1 {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<>();

            if (s == null || words == null || s.length() == 0 || words.length == 0) return res;

            int wordLength = words[0].length();
            int windowLength = wordLength * words.length;


            Map<String, Integer> map = new HashMap<>();

            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }

            Map<String, Integer> curMap = new HashMap<>();
            int begin, end, counter;
            // Sliding window
            for (int i=0;i<wordLength;i++) {
                curMap.clear();
                curMap.putAll(map);
                counter = map.size();
                begin = i;
                end = i;

                while (end + wordLength <= s.length()) { // process till the end of string

                    String lastWord = s.substring(end, end+wordLength);

                    if (curMap.containsKey(lastWord)) {
                        curMap.put(lastWord, curMap.get(lastWord) - 1);
                        if (curMap.get(lastWord) == 0) counter--;
                    }

                    if (end + wordLength - begin == windowLength) {
                        if (counter == 0) res.add(begin);

                        String firstWord = s.substring(begin, begin + wordLength);

                        if (curMap.containsKey(firstWord)) {
                            curMap.put(firstWord, curMap.get(firstWord) + 1);
                            if (curMap.get(firstWord) > 0) counter++;
                        }

                        begin += wordLength;
                    }

                    end += wordLength;
                }

            }

            return res;

        }
    }
}
