import java.util.Arrays;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Tracks the minimum cost to reach each city
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        // Perform relaxation at most K + 1 times (for K stops)
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(prices, n);

            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int price = flight[2];

                // If the starting city of this flight is reachable
                if (prices[u] != Integer.MAX_VALUE) {
                    if (prices[u] + price < temp[v]) {
                        temp[v] = prices[u] + price;
                    }
                }
            }
            prices = temp;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
