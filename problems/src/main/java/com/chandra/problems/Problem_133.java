package com.chandra.problems;

import com.chandra.common.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 133. Clone Graph
 Clone an undirected graph.
 Each node in the graph contains a label and a list of its neighbors.
 OJ's undirected graph serialization:
 Nodes are labeled uniquely.
 We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 The graph has a total of three nodes, and therefore contains three parts as separated by #.
 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 Second node is labeled as 1. Connect node 1 to node 2.
 Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 Visually, the graph looks like the following:
             1
            / \
           /   \
          0 --- 2
               / \
               \_/
 */

public class Problem_133 {

    // DFS
    public static class Solution_1 {
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            Map<Integer, UndirectedGraphNode> map = new HashMap<>();
            return dfs(node, map);
        }

        public UndirectedGraphNode dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
            if (node == null) return null;
            if (map.containsKey(node.label)) return map.get(node.label);
            UndirectedGraphNode clonedNode = new UndirectedGraphNode(node.label);
            map.put(node.label, clonedNode);
            for (UndirectedGraphNode n : node.neighbors) {
                clonedNode.neighbors.add(dfs(n, map));
            }
            return clonedNode;
        }
    }

    // BFS
    public static class Solution_2 {
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode root) {
            if (root == null) return root;

            Map<Integer, UndirectedGraphNode> map = new HashMap<>();
            Queue<UndirectedGraphNode> queue = new LinkedList<>();
            UndirectedGraphNode clonedNode = new UndirectedGraphNode(root.label);
            map.put(clonedNode.label, clonedNode);
            queue.offer(root);

            while (!queue.isEmpty()) {
                UndirectedGraphNode node = queue.poll();
                for (UndirectedGraphNode n : node.neighbors) {
                    if (!map.containsKey(n.label)) {
                        map.put(n.label, new UndirectedGraphNode(n.label));
                        queue.offer(n);
                    }
                    map.get(node.label).neighbors.add(map.get(n.label));
                }
            }

            return clonedNode;
        }
    }
}
