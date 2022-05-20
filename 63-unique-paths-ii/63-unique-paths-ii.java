class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        
        if(obstacleGrid[0][0]==1 || obstacleGrid[n-1][m-1]==1)
            return 0;
        int[][] dp = new int[n][m];
        int[][] dir = {{1,0},{0,1}};
        // int ans = uniquePathsWithObstaclesMemo(obstacleGrid, 0, 0, n-1, m-1, dp, dir);
        int ans = uniquePathsWithObstacles_Tab(obstacleGrid, 0, 0, n-1, m-1, dp, dir);
        return ans;
    }
    
    public int uniquePathsWithObstacles_Tab(int[][] obstacleGrid, int SR,int SC, int ER, int EC,int[][] dp, int[][] dir)
    {
        for(int sr=ER;sr>=SR;sr--)
        {
            for(int sc=EC;sc>=SC;sc--)
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
                    if(r>=0 && c>=0 && r<dp.length && c<dp[0].length && obstacleGrid[r][c]==0)
                    {
                        count += dp[r][c]; //uniquePathsWithObstaclesMemo(obstacleGrid, r, c, er, ec, dp, dir);
                    }
                }
                dp[sr][sc] = count;
            }
        }
        return dp[SR][SC];
    }
}