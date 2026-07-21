import java.util.Arrays;

public class LC1402 {
    public int maxSatisfaction(int[] satisfaction) {
        // Sort in ascending order first
        Arrays.sort(satisfaction);
        
        int totalSatisfaction = 0;
        int currentSum = 0;
        
        // Iterate from most satisfying to least satisfying (end to start)
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            currentSum += satisfaction[i];
            
            if (currentSum < 0) {
                break;
            }
            
            totalSatisfaction += currentSum;
        }
        
        return totalSatisfaction;
    }
}
