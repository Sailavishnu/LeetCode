public class LC75 {
    public void sortColors(int[] nums) {
        int l = 0;
        int i = 0;
        int r = nums.length - 1;
        
        while (i <= r) {
            if (nums[i] == 0) {
                int t = nums[i];
                nums[i] = nums[l];
                nums[l] = t;
                i++;
                l++;
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                int t = nums[i];
                nums[i] = nums[r];
                nums[r] = t;
                r--;
            }
        }
    }
}
