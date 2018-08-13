package com.chandra.problems;

import com.chandra.common.TreeNode;

import java.util.*;

/**	314 Binary Tree Vertical Order Traversal
 *
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 If two nodes are in the same row and column, the order should be from left to right.
 Examples:
 Given binary tree [3,9,20,null,null,15,7],
     3
    / \
   9  20
     /  \
    15   7
 return its vertical order traversal as:
 [
 [9],
 [3,15],
 [20],
 [7]
 ]
 Given binary tree [3,9,8,4,0,1,7],
      3
    /   \
   9    8
 /  \  /  \
 4  0 1   7
 return its vertical order traversal as:
 [
 [4],
 [9],
 [3,0,1],
 [8],
 [7]
 ]
 Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
          3
        /   \
       9    8
      /  \ /  \
     4  0 1   7
      /  \
     5   2
 return its vertical order traversal as:
 [
 [4],
 [9,5],
 [3,0,1],
 [8,2],
 [7]
 ]*/
public class Problem_314 {

    public static class Solution_1 {
        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            TreeMap<Integer, List<Integer>> map = new TreeMap<>();
            verticalOrderHelper(root, 0, map);
            for (Map.Entry<Integer, List<Integer>> list : map.entrySet()) {
                res.add(list.getValue());
            }
            return res;
        }

        private void verticalOrderHelper(TreeNode node, int hd, TreeMap<Integer, List<Integer>> map) {
            // Base case
            if (node == null) return;

            if (!map.containsKey(hd)) map.put(hd, new ArrayList<>());

            map.get(hd).add(node.val);
            verticalOrderHelper(node.left, hd - 1, map);
            verticalOrderHelper(node.right, hd + 1, map);
        }
    }

    public static void main(String[] args) {
        Solution_1 solution_1 = new Solution_1();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        solution_1.verticalOrder(root);
        /* Output
        [9]
        [3, 15]
        [20]
        [7]
         */
    }
}
