public void setZeroes(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    boolean firstRowHasZero = false;
    boolean firstColHasZero = false;
    int r,c;

    // 1. Check if first row or first col have zeroes initially
    for ( c =0 ; c< cols - 1 ; c++){
        if (matrix[0][c] == 0){
            firstRowHasZero =true;
            break;
        }
    }

    for ( r =0 ; r< rows - 1 ; r++){
        if (matrix[r][0] == 0){
            firstRowHasZero =true;
            break;
        }
    }
    
    // 2. Iterate through rest of matrix to mark headers
    
    for ( r=0 ; r < rows -1 ; r++){
        for ( c=0; c < cols -1 ; c++){
            if( matrix[r][c] ==0 ){
                matrix[r][0] = 0;
                matrix[0][c] = 0;
            }
        }
    }
    // 3. Iterate through rest of matrix to update values based on headers
    
    for ( r=0 ; r < rows -1 ; r++){
        for ( c=0; c < cols -1 ; c++){
            if( matrix[r][0] = 0 || matrix[0][c] = 0){
                matrix[r][c] = 0;
            }
        }
    }
    // 4. Update first row and column based on the initial flags
    if (firstRowHasZero){
        for ( c =0 ; c< cols - 1 ; c++)  matrix[0][c] = 0; 
    }

    if (firstColHasZero){
        for ( r=0 ; r<rows -1; r++ ) matrix[r][0] =0;
    }
}
