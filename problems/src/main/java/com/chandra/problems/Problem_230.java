package com.chandra.problems;

import com.chandra.common.TreeNode;

import java.util.Stack;

/**
 * 230. Kth Smallest Element in a BST
 *
 *  Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

 Example 1:

 Input: root = [3,1,4,null,2], k = 1
      3
     / \
    1   4
     \
      2
 Output: 1
 Example 2:

 Input: root = [5,3,6,2,4,null,null,1], k = 3
         5
        / \
       3   6
      / \
    2   4
   /
 1
 Output: 3
 Follow up:
 What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */
public class Problem_230 {
    public static class Solution_1 {
        int count = 0, res = 0;
        public int kthSmallest(TreeNode root, int k) {
            count = k;
            dfsInOrder(root);
            return res;
        }

        private void dfsInOrder(TreeNode root) {
            if(root.left != null) {
                dfsInOrder(root.left);
            }
            count--;
            if (count == 0) {
                res = root.val;
                return;
            }
            if (root.right != null) {
                dfsInOrder(root.right);
            }
        }
    }


    public static class Solution_2 {

        // BFS
        public int kthSmallest(TreeNode root, int k) {
            Stack<TreeNode> stack = new Stack<>();
            while (root.left != null) {
                stack.push(root);
                root = root.left;
            }

            while (k > 0) {
                TreeNode temp = stack.pop();
                if (--k == 0) return temp.val;
                temp = temp.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            }

            return - 1;
        }
    }
}
