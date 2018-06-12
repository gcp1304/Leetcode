package com.chandra.problems;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * 215. Kth Largest Element in an Array
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 *
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class Problem_215 {

    public static class Solution1 {
        //O(N lg N) running time + O(1) memory
        public int findKthLargest(int[] nums, int k) {
            int len = nums.length;
            Arrays.sort(nums);
            return nums[len - k];
        }
    }

    public static class Solution2 {
        // O(N lg K) running time + O(K) memory
        public int findKthLargest(int[] nums, int k) {
            // using min heap
            Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

            for (int num : nums) {
                pq.offer(num);
                if (pq.size() > k) pq.poll();
            }

            return pq.peek();
        }
    }


    // Quick select - worst case O(n^2)
    // Depending on pivot selection strategy, time complexity can be reduced to O(n)
    public static class Solution3 {
        public int findKthLargest(int[] nums, int k) {
            int start = 0, end = nums.length - 1, index = nums.length - k;

            while (start < end) {
                int pivot = partition(nums, start, end);
                if (pivot < index) start = pivot + 1; // check right part
                else if (pivot > index) end = pivot - 1; // check left part
                else return nums[pivot]; // found kth smallest number
            }

            return nums[start];
        }

        // partition the array such that numbers less than pivot is on left and greater ones are on right
        private int partition(int[] nums, int start, int end) {
            int pivot = start, temp;
            while (start <= end) {
                while (start <= end && nums[start] <= nums[pivot]) start++;
                while (start <= end && nums[end] > nums[pivot]) end--;
                if (start > end) break;
                temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
            temp = nums[end];
            nums[end] = nums[pivot];
            nums[pivot] = temp;
            return end;
        }
    }


}
