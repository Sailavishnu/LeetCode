class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // dp[i][j] represents if s[0...i-1] matches p[0...j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: empty string matches empty pattern
        dp[0][0] = true;
        
        // Deals with patterns like a*, a*b*, .* that can match an empty string
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char currentP = p.charAt(j - 1);
                char currentS = s.charAt(i - 1);
                
                if (currentP == currentS || currentP == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (currentP == '*') {
                    // Case 1: Match 0 times of the preceding element
                    dp[i][j] = dp[i][j - 2];
                    
                    // Case 2: Match 1 or more times if preceding element matches currentS
                    char precedingP = p.charAt(j - 2);
                    if (precedingP == currentS || precedingP == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
}
