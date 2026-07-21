import java.util.*;

class Solution {
    public String makeLargestSpecial(String s) {
        List<String> res = new ArrayList<>();
        int count = 0;
        int i = 0;
        
        // Split s into its top-level independent special substrings
        for (int j = 0; j < s.length(); ++j) {
            if (s.charAt(j) == '1') {
                count++;
            } else {
                count--;
            }
            
            // Found a complete independent special substring
            if (count == 0) {
                // Recursively process the inner content: s.substring(i + 1, j)
                // Wrap it back with the outer '1' and '0'
                res.add("1" + makeLargestSpecial(s.substring(i + 1, j)) + "0");
                i = j + 1; // Move pointer to the next substring start
            }
        }
        
        // Sort components in descending order to maximize lexicographical value
        Collections.sort(res, Collections.reverseOrder());
        
        // Join the sorted parts back together
        return String.join("", res);
    }
}
