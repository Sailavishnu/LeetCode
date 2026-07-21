import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        
        // Step 1: Sort the array to ensure nums[i] >= nums[j] when i > j
        Arrays.sort(nums);
        int n = nums.length;
        
        int[] dp = new int[n];
        int[] parent = new int[n];
        
        Arrays.fill(dp, 1);     // Every element is a valid subset of size 1
        Arrays.fill(parent, -1); // -1 means no predecessor
        
        int maxSize = 1;
        int maxIndex = 0;
        
        // Step 2: Fill DP array and track parents
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            // Track the global maximum subset length and its ending index
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }
        
        // Step 3: Reconstruct the subset using the parent array
        int curr = maxIndex;
        while (curr != -1) {
            result.add(nums[curr]);
            curr = parent[curr];
        }
        
        return result;
    }
}
