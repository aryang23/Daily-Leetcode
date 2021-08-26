class Solution {
    public void rotate(int[][] matrix) {
        //Transpose and then reverse the rows
        int n = matrix.length, m = matrix[0].length;
        transpose(matrix);
      
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m/2;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m-j-1];
                matrix[i][m-j-1] = temp;
            }
        }
    }
    
  //BEST FUNCTIOn
    public void transpose(int[][] matrix)
    {
        int n = matrix.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
}
