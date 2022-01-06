class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        int maxx = 0;
        for(int i=n-1;i>=0;i--)
        {
            for(int j=m-1;j>=0;j--)
            {
                if(i==n-1 || j==m-1)
                    dp[i][j] = (matrix[i][j] - '0');
                else
                {
                    if(matrix[i][j] == '1')
                    {
                        int ans = Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1])) + 1;
                        dp[i][j] = ans;
                    }
                }
                maxx = Math.max(maxx, dp[i][j]);
            }
        }
        return maxx*maxx;
    }
}
