class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        
        for(int i=0;i<n;i++)
        {
            int rowXor = 0;
            int colXor = 0;
            for(int j=0;j<n;j++)
            {
                rowXor ^= matrix[i][j]^(j+1);
                colXor ^= matrix[j][i] ^ (j+1);
            }
            if(rowXor != 0 || colXor != 0)
                return false;
        }
        return true;
    }
}
