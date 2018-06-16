package com.chandra.problems;

import com.chandra.common.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 404. Sum of Left Leaves
 *
 * Find the sum of all left leaves in a given binary tree.

 Example:

         3
        / \
       9  20
         /  \
        15   7

 There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class Problem_404 {

    // DFS
    public static class Solution_1 {
        public int sumOfLeftLeaves(TreeNode root) {
            return dfs(root, false);
        }

        public int dfs(TreeNode node, boolean isLeft) {
            if (node == null) return 0;

            if (isLeft == true && node.left == null && node.right == null) return node.val;
            return dfs(node.left, true) + dfs(node.right, false);
        }
    }

    // Recursive
    public static class Solution_2 {
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) return 0;
            int ans = 0;
            if (root.left != null) {
                if (root.left.left == null && root.left.right == null) ans += root.left.val;
                else ans += sumOfLeftLeaves(root.left);
            }
            if (root.right != null)
                ans += sumOfLeftLeaves(root.right);
            return ans;
        }
    }

    // Iterative
    public static class Solution_3 {
        public int sumOfLeftLeaves(TreeNode root) {
            if(root == null) return 0;

            int ans = 0;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.left != null) {
                    if (node.left.left == null && node.left.right == null) ans += node.left.val;
                    else stack.push(node.left);
                }

                if (node.right != null) {
                    if (node.right.left != null || node.right.right != null) {
                        stack.push(node.right);
                    }
                }
            }
            return ans;
        }
    }
}
