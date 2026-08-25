class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findBound(nums, target, true);  // Find first position
        result[1] = findBound(nums, target, false); // Find last position
        return result;
    }

    private int findBound(int[] nums, int target, boolean isFindingLeft) {
        int left = 0;
        int right = nums.length - 1;
        int boundIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                boundIndex = mid; // Record the potential answer
                
                if (isFindingLeft) {
                    right = mid - 1; // Keep looking left
                } else {
                    left = mid + 1;  // Keep looking right
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return boundIndex;
    }
}
