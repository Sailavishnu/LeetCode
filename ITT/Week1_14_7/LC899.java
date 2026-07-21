import java.util.Arrays;

class Solution {
    public String orderlyQueue(String s, int k) {
        // Case 1: If k > 1, we can fully sort the string
        if (k > 1) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
        
        // Case 2: If k == 1, find the lexicographically smallest rotation
        String smallest = s;
        for (int i = 1; i < s.length(); i++) {
            String rotation = s.substring(i) + s.substring(0, i);
            if (rotation.compareTo(smallest) < 0) {
                smallest = rotation;
            }
        }
        
        return smallest;
    }
}
