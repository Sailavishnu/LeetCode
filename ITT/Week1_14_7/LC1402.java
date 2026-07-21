import java.util.Arrays;

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        // Step 1: Sort the dishes by satisfaction level
        Arrays.sort(satisfaction);
        
        int maxLikeTime = 0;
        int currentPrefixSum = 0;
        
        // Step 2: Traverse backwards from the most satisfying dish
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            // Include the current dish into our selected subset sum
            currentPrefixSum += satisfaction[i];
            
            // If the cumulative sum is positive, it increases our total coefficient
            if (currentPrefixSum > 0) {
                maxLikeTime += currentPrefixSum;
            } else {
                // If it becomes negative, adding further dishes will reduce our total
                break;
            }
        }
        
        return maxLikeTime;
    }
}
