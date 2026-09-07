import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        // Map each stop to the list of routes that pass through it
        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToRoutes.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        // If source or target doesn't exist in any route, journey is impossible
        if (!stopToRoutes.containsKey(source) || !stopToRoutes.containsKey(target)) return -1;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        boolean[] visitedRoutes = new boolean[routes.length];

        queue.offer(source);
        visitedStops.add(source);
        int busCount = 0;

        // Standard BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            busCount++;

            for (int i = 0; i < size; i++) {
                int currentStop = queue.poll();

                // Check all routes passing through the current stop
                for (int routeId : stopToRoutes.get(currentStop)) {
                    if (visitedRoutes[routeId]) continue;
                    visitedRoutes[routeId] = true;

                    // Check all stops in the current route
                    for (int nextStop : routes[routeId]) {
                        if (nextStop == target) return busCount;
                        
                        if (!visitedStops.contains(nextStop)) {
                            visitedStops.add(nextStop);
                            queue.offer(nextStop);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
