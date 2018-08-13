package com.chandra.problems;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 *
 * Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].

 Note:
 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class Problem_347 {
    public static class Solution_1 {
        public static List<Integer> topKFrequent(int[] nums, int k) {
            List<Integer> result = new ArrayList<>();
            if (nums == null || nums.length == 0 || k == 0) return result;

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums)
                map.put(num, map.getOrDefault(num, 0)+1);

            PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o1.getValue() - o2.getValue();
                }
            });

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                pq.offer(entry);
                while (pq.size() > k) pq.poll();
            }

            while(!pq.isEmpty())
                result.add(0, pq.poll().getKey());


            return result;
        }

        public static void main(String[] args) {
            int[] nums = {1,1,1,2,2,3};
            int k = 2;
            System.out.println(topKFrequent(nums, k).toString());
        }
    }
}
