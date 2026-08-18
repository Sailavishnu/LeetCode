import java.util.*;

class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long originalProfit = 0;
        
        for (int i = 0; i < n; i++) {
            originalProfit += (long) strategy[i] * prices[i];
        }
        
        long currentWindowGain = 0;
        int half = k / 2;
        for (int i = 0; i < k; i++) {
            int newStrat = (i < half) ? 0 : 1;
            currentWindowGain += (long) (newStrat - strategy[i]) * prices[i];
        }
        
        long maxAdditionalGain = currentWindowGain;
        
        for (int i = k; i < n; i++) {
            int oldOutIdx = i - k;
            currentWindowGain -= (long) (0 - strategy[oldOutIdx]) * prices[oldOutIdx];
            
            int shiftIdx = i - half;
            currentWindowGain -= (long) (1 - strategy[shiftIdx]) * prices[shiftIdx];
            currentWindowGain += (long) (0 - strategy[shiftIdx]) * prices[shiftIdx];
            
            currentWindowGain += (long) (1 - strategy[i]) * prices[i];
            
            maxAdditionalGain = Math.max(maxAdditionalGain, currentWindowGain);
        }
        
        return originalProfit + Math.max(0, maxAdditionalGain);
    }
}
