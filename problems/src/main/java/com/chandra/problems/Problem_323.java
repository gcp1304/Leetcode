package com.chandra.problems;

import java.util.*;

/**
 * 323. Number of Connected Components in an Undirected Graph
 *
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges
 * (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
 * Example 1:
 * 0          3
 * |          |
 * 1 --- 2    4
 *
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 * Example 2:
 * 0           4
 * |           |
 * 1 --- 2 --- 3
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
 *
 * Note:
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is
 * the same as [1, 0] and thus will not appear together in edges.
 */

public class Problem_323 {
    public static class Solution_1 {
        public int countComponents(int n, int[][] edges) {
            List<List<Integer>> adjList = new ArrayList<>();

            boolean[] visited = new boolean[n];
            Arrays.fill(visited, false);

            int ans = 0;

            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }

            // building the graph's adjacency list
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                adjList.get(from).add(to);
                adjList.get(to).add(from);
            }

            // dfs on nodes to find connected components
            Deque<Integer> stack = new ArrayDeque<>();
            for (int node = 0; node < n; node++) {
                if (!visited[node]) {
                    ans++;
                    stack.push(node);
                }

                while (!stack.isEmpty()) {
                    int currentNode = stack.pop();
                    visited[currentNode] = true;
                    for (Integer neighbor : adjList.get(currentNode)) {
                        if (!visited[neighbor]) stack.push(neighbor);
                    }
                }
            }

            return ans;
        }
    }
}
