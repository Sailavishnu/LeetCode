class Solution {
    public int trap(int[] height) {
        int i=0,j=height.length-1,leftmax=0,rightmax=0,ans=0;
        while(i<j){
            leftmax=Math.max(leftmax,height[i]);
            rightmax=Math.max(rightmax,height[j]);
            ans+=(leftmax<rightmax)?leftmax-height[i++]:rightmax-height[j--];
        } 
        return ans;  
    }
}