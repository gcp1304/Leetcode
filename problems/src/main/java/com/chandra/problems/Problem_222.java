package com.chandra.problems;

import com.chandra.common.TreeNode;

/**
 * 222. Count Complete Tree Nodes
 *
 * Given a complete binary tree, count the number of nodes.

 Note:

 Definition of a complete binary tree from Wikipedia:
 In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

 Example:

 Input:
        1
       / \
      2   3
     / \  /
    4  5 6

 Output: 6

 */
public class Problem_222 {
    public static class Solution_1 {

        /**
         * Find left tree height and right tree height
         * If both are same then there are 2^(leftHeight or rightHeight) - 1 number of nodes
         * If both are not same then recursively determine the number of nodes at every level adding 1 for root node at each level
         */
        public int countNodes(TreeNode root) {
            int leftHeight = height(root, true);
            int rightHeight = height(root, false);
            if (leftHeight == rightHeight) // tree has all the nodes
                return (1 << leftHeight) - 1;
            else
                return 1 + countNodes(root.left) + countNodes(root.right);
        }

        private int height(TreeNode root, boolean isLeft) {
            if (root == null) return 0;
            return isLeft ? 1+height(root.left, isLeft) : 1+height(root.right, isLeft);
        }
    }
}
