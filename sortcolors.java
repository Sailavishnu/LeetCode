class Solution {
    public void sortColors(int[] nums) {
       int l=0,i=0,r=nums.length-1,t;
       while(i<=r){
            if(nums[i]==0){
                t = nums[i];
                nums[i] = nums[l];
                nums[l] = t;
                i++;
                l++;
            }
            else if(nums[i]==1){
                i++;
            }
            else if(nums[i]==2){
                t = nums[i];
                nums[i] = nums[r];
                nums[r] = t;
                r--;
            }
       }
    }
}