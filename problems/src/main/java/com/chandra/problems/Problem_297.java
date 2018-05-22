package com.chandra.problems;

import com.chandra.common.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. Serialize and Deserialize Binary Tree
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits
 * so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can
 * be deserialized to the original tree structure.
 * For example, you may serialize the following tree
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * as "[1,2,3,null,null,4,5]",
 * just the same as how LeetCode OJ serializes a binary tree.
 * You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */

public class Problem_297 {
    public static class Solution_1 {
        /**
         * The idea is very straightforward:
         * use "#" as the terminator, do BFS, level order traversal to store all nodes values into a StringBuilder.
         * When deserializing, also use a queue: pop the root into the queue first, then use a for loop to construct each node,
         * then eventually just return the root.
         */

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }

            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size != 0) {
                    TreeNode node = queue.poll();
                    if (node == null) {
                        sb.append("# ");
                        continue;
                    }

                    sb.append(node.val);
                    sb.append(" ");
                    queue.offer(node.left);
                    queue.offer(node.right);
                    size--;
                }
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty()) {
                return null;
            }

            String[] nodes = data.split(" ");
            TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int i = 1;
            while (i < nodes.length) {
                TreeNode curr = queue.poll();
                if (!nodes[i].equals("#")) {
                    curr.left = new TreeNode(Integer.valueOf(nodes[i]));
                    queue.offer(curr.left);
                }
                i++;
                if (!nodes[i].equals("#")) {
                    curr.right = new TreeNode(Integer.valueOf(nodes[i]));
                    queue.offer(curr.right);
                }
                i++;
            }
            return root;
        }
    }

    public static class Solution_2 {
        private static final String NN = "#";
        private static final String SPLITTER = " ";
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serializeHelper(root, sb);
            return sb.toString();
        }

        private void serializeHelper(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append(NN).append(SPLITTER);
            } else {
                // Preorder traversal
                sb.append(node.val).append(SPLITTER);
                serializeHelper(node.left, sb);
                serializeHelper(node.right, sb);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Deque<String> nodes = new LinkedList<>();
            nodes.addAll(Arrays.asList(data.split(SPLITTER)));
            return deserializeHelper(nodes);
        }

        private TreeNode deserializeHelper(Deque<String> nodes) {
            String val = nodes.poll();
            if (val.equals(NN)) return null;
            else {
                TreeNode node = new TreeNode(Integer.valueOf(val));
                node.left = deserializeHelper(nodes);
                node.right = deserializeHelper(nodes);
                return node;
            }
        }
    }
}
