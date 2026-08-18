class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxLinearSum = nums[0];
        int minLinearSum = nums[0];
        int currentMax = 0;
        int currentMin = 0;
        
        for (int num : nums) {
            totalSum += num;
            
            // Standard Kadane's to find max subarray
            currentMax = Math.max(num, currentMax + num);
            maxLinearSum = Math.max(maxLinearSum, currentMax);
            
            // Inverted Kadane's to find min subarray
            currentMin = Math.min(num, currentMin + num);
            minLinearSum = Math.min(minLinearSum, currentMin);
        }
        
        // Edge Case: If all numbers are negative, totalSum == minLinearSum.
        // Returning (totalSum - minLinearSum) would result in 0 (an empty subarray),
        // which is invalid because the problem requires a non-empty subarray.
        if (maxLinearSum < 0) {
            return maxLinearSum;
        }
        
        // Return the larger of the two cases
        return Math.max(maxLinearSum, totalSum - minLinearSum);
    }
}
