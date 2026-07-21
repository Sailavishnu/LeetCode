import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Get the index mapped by the current value
            int index = Math.abs(nums[i]) - 1;
            
            // If the element at that index is negative, it's a duplicate
            if (nums[index] < 0) {
                result.add(index + 1);
            } else {
                // Mark the index as visited by negating its value
                nums[index] = -nums[index];
            }
        }
        
        return result;
    }
}