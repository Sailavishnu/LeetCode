import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Handle edge case where a 4sum is impossible
        if (nums == null || nums.length < 4) {
            return result;
        }
        
        // 1. Sort the array
        Arrays.sort(nums);
        int n = nums.length;
        
        // 2. First loop for the first number
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate values for the first position
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // 3. Second loop for the second number
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate values for the second position
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                
                // 4. Two pointers initialization
                int left = j + 1;
                int right = n - 1;
                
                while (left < right) {
                    // Use long to prevent integer overflow during addition
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        // Skip duplicates for the third position
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // Skip duplicates for the fourth position
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++; // Need a larger sum
                    } else {
                        right--; // Need a smaller sum
                    }
                }
            }
        }
        return result;
    }
}
