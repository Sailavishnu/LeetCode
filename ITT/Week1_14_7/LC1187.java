import java.util.*;

class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        // Step 1: Sort arr2 and remove duplicates to facilitate binary search
        Arrays.sort(arr2);
        List<Integer> uniqueArr2 = new ArrayList<>();
        for (int num : arr2) {
            if (uniqueArr2.isEmpty() || uniqueArr2.get(uniqueArr2.size() - 1) != num) {
                uniqueArr2.add(num);
            }
        }

        // dp maps: ending_value -> minimum_operations
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(-1, 0); // Base case: before index 0, ending value is -1 with 0 ops

        // Step 2: Process each element in arr1
        for (int currentVal : arr1) {
            Map<Integer, Integer> nextDp = new HashMap<>();

            for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                int prevVal = entry.getKey();
                int currentOps = entry.getValue();

                // Option 1: Keep the current value from arr1
                if (currentVal > prevVal) {
                    nextDp.put(currentVal, Math.min(nextDp.getOrDefault(currentVal, Integer.MAX_VALUE), currentOps));
                }

                // Option 2: Replace the value with a valid choice from arr2
                int replacementIdx = upperBound(uniqueArr2, prevVal);
                if (replacementIdx < uniqueArr2.size()) {
                    int replacementVal = uniqueArr2.get(replacementIdx);
                    nextDp.put(replacementVal, Math.min(nextDp.getOrDefault(replacementVal, Integer.MAX_VALUE), currentOps + 1));
                }
            }

            // If no valid states can be reached, it's impossible
            if (nextDp.isEmpty()) {
                return -1;
            }
            dp = nextDp;
        }

        // Step 3: Find the global minimum operations from the final map
        int minOps = Integer.MAX_VALUE;
        for (int ops : dp.values()) {
            minOps = Math.min(minOps, ops);
        }

        return minOps == Integer.MAX_VALUE ? -1 : minOps;
    }

    // Helper method to find the first element strictly greater than target
    private int upperBound(List<Integer> list, int target) {
        int low = 0;
        int high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
