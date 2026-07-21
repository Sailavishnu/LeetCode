import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        // 1. Sort the array
        Arrays.sort(nums);
        
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        
        int maxLen = 1;
        int maxIdx = 0;
        
        // Initialize DP states
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        
        // 3. Compute DP transitions
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }
        
        // 4. Reconstruct the subset
        int curr = maxIdx;
        while (curr != -1) {
            result.add(0, nums[curr]);
            curr = parent[curr];
        }
        
        return result;
    }
}
