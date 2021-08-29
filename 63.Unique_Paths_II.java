class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // int count = uniquePathsWithObstacles(obstacleGrid, 0, 0, obstacleGrid.length, obstacleGrid[0].length);
        
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        
        if(obstacleGrid[0][0]==1 || obstacleGrid[n-1][m-1]==1)
            return 0;
        int[][] dp = new int[n][m];
        int[][] dir = { { 1, 0 }, { 0, 1 } };

        // int ans = uniquePathsWithObstacles(obstacleGrid, 0, 0, n, m);
        // int ans = uniquePathsWithObstaclesMemo(obstacleGrid, 0, 0, n-1, m-1, dp,dir);
        int ans = uniquePathsWithObstaclesTab(obstacleGrid, 0, 0, n-1, m-1, dp, dir);
        return ans;
        
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid, int i, int j, int n,int m)
    {
        if(i<0 || j<0 || i>=n || j>=m || obstacleGrid[i][j]==1)
            return 0;
        
        if(i==n-1 && j==m-1)
            return 1;
        
        int count = 0;
        count += uniquePathsWithObstacles(obstacleGrid, i, j+1, n, m);
        count += uniquePathsWithObstacles(obstacleGrid, i+1, j, n, m);
        
        return count;
    }
    
    public int uniquePathsWithObstaclesMemo(int[][] obstacleGrid, int sr, int sc, int er, int ec, int[][] dp, int[][] dir)
    {
        if(sr==er && sc==ec)
        {
            return dp[sr][sc] = 1;
        }
        
        if(dp[sr][sc]!=0)
            return dp[sr][sc];
        
        int count = 0;
        for(int[] d:dir)
        {
            int r = sr+d[0];
            int c = sc+d[1];
            
            if (r >= 0 && c >= 0 && r < dp.length && c < dp[0].length && obstacleGrid[r][c]==0)
            {
                count+=uniquePathsWithObstaclesMemo(obstacleGrid, r, c, er, ec, dp, dir);
            }
        }
        return dp[sr][sc] = count;
    }
    
    public int uniquePathsWithObstaclesTab(int[][] obstacleGrid, int SR, int SC, int ER, int EC, int[][] dp, int[][] dir)
    {
        
        for (int sr = ER; sr >= SR; sr--)
        {
            for (int sc = EC; sc >= SC; sc--)
            {
                if(sr==ER && sc==EC)
                {
                    dp[sr][sc] = 1;
                    continue;
                }
                
                int count = 0;
                for(int[] d:dir)
                {
                    int r = sr+d[0];
                    int c = sc+d[1];

                    if (r >= 0 && c >= 0 && r < dp.length && c < dp[0].length && obstacleGrid[r][c] == 0)
                    {
                        count+=dp[r][c];
                    }
                }
                dp[sr][sc] = count;
            }
        }
        return dp[SR][SC];
    }
}
