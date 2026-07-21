import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                
                // Skip empty slots
                if (val != '.') {
                    // Try to insert row, column, and box constraints
                    // If any .add() returns false, it means a duplicate exists!
                    if (!seen.add(val + " row " + r) || 
                        !seen.add(val + " col " + c) || 
                        !seen.add(val + " box " + (r / 3) + "-" + (c / 3))) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}
