import java.util.Arrays;
import java.util.Comparator;

public class LC179 {
    public String largestNumber(int[] nums) {
        // Convert to String array
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        
        // Sort using custom comparator
        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String ab = a + b;
                String ba = b + a;
                // Sort in descending order: compare ba to ab
                return ba.compareTo(ab);
            }
        });
        
        // Edge case: if the largest number is "0", the result is "0"
        if (strNums[0].equals("0")) {
            return "0";
        }
        
        // Join all strings
        StringBuilder sb = new StringBuilder();
        for (String s : strNums) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}
