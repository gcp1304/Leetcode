package com.chandra.problems;

/**
 * 852. Peak Index in a Mountain Array
 *
 * Let's call an array A a mountain if the following properties hold:

 A.length >= 3
 There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

 Example 1:

 Input: [0,1,0]
 Output: 1
 Example 2:

 Input: [0,2,1,0]
 Output: 1
 Note:

 3 <= A.length <= 10000
 0 <= A[i] <= 10^6
 A is a mountain, as defined above.
 */
public class Problem_852 {

    public static class Solution_1 {
        // Linear Time
        // Time : O(N) , Space: O(1)
        public int peakIndexInMountainArray(int[] A) {
            int i=0;
            while (A[i] < A[i+1]) i++;
            return i;
        }
    }

    public static class Solution_2 {
        // Binary Search
        // Time : O(logN), Space: O(1)
        public int peakIndexInMountainArray(int[] A) {
            int start = 0, end = A.length;
            while(start < end) {
                int mid = (end - start) / 2 + start;
                if (A[mid-1] < A[mid] && A[mid+1] < A[mid]) return mid;

                if (A[mid+1] > A[mid]) start = mid;
                else end = mid;
            }
            return -1;
        }

        //problem statement says that atleast one peak is guaranteed we can simplify the above code
        public int peakIndexMountainArrayII(int[] A) {
            int start = 0, end = A.length-1;
            while (start < end) {
                int mid = (end - start)/2 + start;
                if (A[mid] < A[mid+1]) start = mid+1; // peak index is after mid.
                else end = mid; // peak index <= mid.
            }
            return start; // found peak index.
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 1};
        System.out.println(new Problem_852.Solution_1().peakIndexInMountainArray(A)); // 3
    }
}
