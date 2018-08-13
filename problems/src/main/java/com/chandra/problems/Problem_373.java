package com.chandra.problems;

import java.util.*;

/**
 * 373. Find K Pairs with Smallest Sums
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

 Define a pair (u,v) which consists of one element from the first array and one element from the second array.

 Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

 Example 1:
 Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

 Return: [1,2],[1,4],[1,6]

 The first 3 pairs are returned from the sequence:
 [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 Example 2:
 Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

 Return: [1,1],[1,1]

 The first 2 pairs are returned from the sequence:
 [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 Example 3:
 Given nums1 = [1,2], nums2 = [3],  k = 3

 Return: [1,3],[2,3]

 All possible pairs are returned from the sequence:
 [1,3],[2,3]
 */
public class Problem_373 {
    // Time : O(klogk)
    public static class Solution_1 {
        public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {

            List<int[]> result = new ArrayList<>();
            if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k==0) return result;
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return (o1[0]+o1[1]) - (o2[0]+o2[1]);
                }
            });

            for (int n1: nums1) {
                for (int n2 : nums2) {
                    pq.offer(new int[]{n1, n2});
                }
            }
            for (int i = 0; i < k; i++) {
                if(pq.isEmpty()) break;
                result.add(pq.poll());
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};

        List<int[]> result = Solution_1.kSmallestPairs(nums1, nums2, 3);

        for(int[] res : result)
            System.out.println(Arrays.toString(res));

    }
}
