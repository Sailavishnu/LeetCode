import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxResult = 0;
        int mask = 0;

        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            
            Set<Integer> prefixes = new HashSet<>();
            for (int num : nums) {
                prefixes.add(num & mask);
            }

            int greedyCandidate = maxResult | (1 << i);

            for (int prefix : prefixes) {
                if (prefixes.contains(prefix ^ greedyCandidate)) {
                    maxResult = greedyCandidate;
                    break;
                }
            }
        }
        return maxResult;
    }
}
