import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        // Step 1: Convert integers to Strings
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        
        // Step 2: Sort strings using the custom concatenation comparator
        // We sort in descending order (s2 + s1 compared to s1 + s2)
        Arrays.sort(strs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        
        // Step 3: Handle the leading zero edge case
        if (strs[0].equals("0")) {
            return "0";
        }
        
        // Step 4: Join all pieces together
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        
        return sb.toString();
    }
}
