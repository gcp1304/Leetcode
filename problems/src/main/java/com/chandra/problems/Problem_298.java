package com.chandra.problems;


import com.chandra.common.TreeNode;

/**
 * 298. Binary Tree Longest Consecutive Sequence
 *
 * Given a binary tree, find the length of the longest consecutive sequence path.

 The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

 For example,

        1
         \
          3
         / \
        2   4
             \
              5
 Longest consecutive sequence path is 3-4-5, so return 3.

        2
         \
          3
         /
        2
       /
      1
 Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */
public class Problem_298 {
    public static class Solution {
        public int longestConsecutive(TreeNode root) {
            if (root == null) return 0;
            return Math.max(longestConsecutiveHelper(root.left, root.val + 1, 1), longestConsecutiveHelper(root.right, root.val + 1, 1));
        }

        private int longestConsecutiveHelper(TreeNode root, int target, int len) {
            if (root == null) return 1;

            len = (root.val == target) ? len + 1 : 1;

            int left = longestConsecutiveHelper(root.left, root.val + 1, len);
            int right = longestConsecutiveHelper(root.right, root.val + 1, len);

            return Math.max(len, Math.max(left, right));
        }
    }

    public static class Solution_1 {
        int len = 0;
        public int longestConsecutive(TreeNode root) {
            if (root == null) return 0;
            longestConsecutiveHelper(root, root.val + 1, 1);
            return len;
        }

        public void longestConsecutiveHelper(TreeNode root, int target, int count) {
            if (root == null) return;

            if (root.val == target) count++;
            else count = 1;

            len = Math.max(len, count);
            longestConsecutiveHelper(root.left, root.val + 1, count);
            longestConsecutiveHelper(root.right, root.val + 1, count);
        }

    }
}
