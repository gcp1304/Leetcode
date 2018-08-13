package com.chandra.problems;

import java.util.*;

/**
 * 692. Top K Frequent Words
 *
 * Given a non-empty list of words, return the k most frequent elements.

 Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

 Example 1:
 Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 Output: ["i", "love"]
 Explanation: "i" and "love" are the two most frequent words.
 Note that "i" comes before "love" due to a lower alphabetical order.
 Example 2:
 Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 Output: ["the", "is", "sunny", "day"]
 Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 with the number of occurrence being 4, 3, 2 and 1 respectively.
 Note:
 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Input words contain only lowercase letters.
 Follow up:
 Try to solve it in O(n log k) time and O(n) extra space.
 */
public class Problem_692 {
    public static class Solution_1 {
        /*
        The idea is to keep a count of each word in a HashMap and then insert in a Priority Queue.
While inserting in pq, if the count of two words is same then insert based on string compare of the keys.


         */
        public List<String> topKFrequent(String[] words, int k) {
            List<String> result = new ArrayList<>();
            if (words == null || words.length == 0 || k == 0) return result;

            HashMap<String, Integer> map = new HashMap<>();
            for (String word : words)
                map.put(word, map.getOrDefault(word, 0) + 1);

            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o1.getValue() == o2.getValue() ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue();
                }
            });

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                pq.offer(entry);
                while (pq.size() > k) pq.poll();
            }

            while (!pq.isEmpty())
                result.add(0, pq.poll().getKey());

            return result;

        }
    }
}
