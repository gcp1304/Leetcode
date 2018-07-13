package com.chandra.problems;

import com.chandra.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/**
 * 144. Binary Tree Preorder Traversal
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.

 Example:

 Input: [1,null,2,3]
        1
         \
         2
        /
       3

 Output: [1,2,3]
 Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class Problem_144 {
    public static class Solution_1 {
        // DFS magic : initialize stack and do the following
        // pop top, retrieve neighbours for top, push unvisited neighbours to stack | repeat while stack not empty
        // because this is a tree no need to keep track of visited as no cycles possible.
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                result.add(root.val);
                // push unvisited neighbours to stack | order matters here, if you reverse it
                // it would still be a DFS but a symmetric one to preorder out of the 6 possible combinations.
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null){
                    stack.push(root.left);
                }
            }

            return result;
        }
    }
}
