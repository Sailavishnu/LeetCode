import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        // Adjacency list: stores [neighbor, sign] 
        // sign = 1 means original direction (away from 0, needs flip)
        // sign = 0 means reverse direction (towards 0, correct)
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] c : connections) {
            graph[c[0]].add(new int[]{c[1], 1}); // Original direction
            graph[c[1]].add(new int[]{c[0], 0}); // Artificial reverse direction
        }

        return dfs(graph, 0, -1);
    }

    private int dfs(List<int[]>[] graph, int node, int parent) {
        int changeCount = 0;

        for (int[] neighbor : graph[node]) {
            int nextNode = neighbor[0];
            int sign = neighbor[1];

            if (nextNode != parent) {
                changeCount += sign; // Add 1 if we are moving along the original direction
                changeCount += dfs(graph, nextNode, node);
            }
        }

        return changeCount;
    }
}
