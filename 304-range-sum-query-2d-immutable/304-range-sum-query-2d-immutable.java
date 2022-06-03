class NumMatrix {

    int[][] presum;
    public NumMatrix(int[][] matrix) {
        int m= matrix.length;
        int n= matrix[0].length;
        presum = new int[m][n];
        presum[0][0] = matrix[0][0];
        
        for(int i=1; i<n; i++) {
            presum[0][i] = presum[0][i-1] + matrix[0][i];
        }
        
        for(int i=1; i<m; i++) {
            presum[i][0] = presum[i-1][0] + matrix[i][0];
        }
        
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                presum[i][j] = matrix[i][j] + presum[i-1][j] + presum[i][j-1] - presum[i-1][j-1];
            }
        }        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = presum[row2][col2];
        
        int minusRow = row1 > 0? presum[row1-1][col2] : 0;
        int minusCol = col1 > 0? presum[row2][col1-1] : 0;
        int addRowCol = row1 > 0 && col1 > 0? presum[row1-1][col1-1] : 0;
        
        return sum - minusRow - minusCol + addRowCol;
    }
}
