package com.chandra.problems;

import com.chandra.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 501. Find Mode in Binary Search Tree
 *
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 Both the left and right subtrees must also be binary search trees.


 For example:
 Given BST [1,null,2,2],

    1
    \
     2
    /
   2


 return [2].

 Note: If a tree has more than one mode, you can return them in any order.

 Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */
public class Problem_501 {
    public static class Solution_1 {
        Map<Integer, Integer> map = new HashMap<>();
        public int[] findMode(TreeNode root) {
            if (root == null) return new int[]{0};
            inorder(root);

            int maxFreq = 0;
            for (int key : map.keySet()) {
                if (map.get(key) > maxFreq)
                    maxFreq = map.get(key);
            }

            List<Integer> modeList = new ArrayList<>();
            for (int key : map.keySet()) {
                if (map.get(key) == maxFreq)
                    modeList.add(key);
            }

            int[] modes = new int[modeList.size()];
            int i=0;
            for (Integer mode : modeList) {
                modes[i++] = mode;
            }

            return modes;
        }

        public void inorder(TreeNode node) {
            if (node == null) return;
            inorder(node.left);
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
            inorder(node.right);
        }
    }
}
