import java.util.*;

class Solution {
    // 4 directions: up, down, left, right
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        // Tracks the minimum effort required to reach each cell
        int[][] efforts = new int[rows][cols];
        for (int[] row : efforts) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        efforts[0][0] = 0;

        // Min-Heap stores [row, col, effort], sorted by effort
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int currEffort = curr[2];

            // Reached the destination cell
            if (r == rows - 1 && c == cols - 1) {
                return currEffort;
            }

            // Skip if we have already found a path with less effort
            if (currEffort > efforts[r][c]) continue;

            // Explore all 4 adjacent neighbors
            for (int[] dir : DIRS) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    // New effort is the max difference along this specific step
                    int nextEffort = Math.max(currEffort, Math.abs(heights[r][c] - heights[nr][nc]));

                    // If this path offers a lower max effort, update and queue it
                    if (nextEffort < efforts[nr][nc]) {
                        efforts[nr][nc] = nextEffort;
                        pq.offer(new int[]{nr, nc, nextEffort});
                    }
                }
            }
        }
        return 0;
    }
}
