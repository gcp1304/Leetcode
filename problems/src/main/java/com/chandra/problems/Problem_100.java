package com.chandra.problems;

import com.chandra.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 100. Same Tree
 *
 * Given two binary trees, write a function to check if they are the same or not.

 Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

 Example 1:

 Input:     1         1
           / \       / \
          2   3     2   3

 [1,2,3],   [1,2,3]

 Output: true
 Example 2:

 Input:      1         1
             /           \
            2             2

 [1,2],     [1,null,2]

 Output: false
 Example 3:

 Input:     1         1
 / \       / \
 2   1     1   2

 [1,2,1],   [1,1,2]

 Output: false
 */

public class Problem_100 {
    public static class Solution_1 {
        // Recursive
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null || q == null) return p == q;

            return (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
        }
    }

    public static class Solution_2 {
        // Recursive
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null || q == null) return p == q;

            Queue<TreeNode> n1 = new LinkedList<>();
            Queue<TreeNode> n2 = new LinkedList<>();

            n1.offer(p);
            n2.offer(q);

            while (!n1.isEmpty() && !n2.isEmpty()) {
                TreeNode first = n1.poll();
                TreeNode second = n2.poll();

                if (first.val != second.val) return false;

                if (first.left != null && second.left != null) {
                    n1.offer(first.left);
                    n2.offer(second.left);
                } else {
                    if (first.left == null && second.left != null) return first.left != null && second.left == null;
                }

                if (first.right != null && second.right != null) {
                    n1.offer(first.right);
                    n2.offer(second.right);
                } else {
                    if (first.right == null && second.right != null) return first.right != null && second.right == null;
                }
            }

            return true;
        }
    }
}
