class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        int[][] dir = { { 1, 0 }, { 0, 1 } };
        // int count = uniquePaths1Helper(m-1, n-1, 0, 0, dir);
        // int count = uniquePathsHelper_Memo(m-1, n-1, 0, 0, dp, dir);
        int count = uniquePathsHelper_Tab(0, 0, m-1, n-1, dp, dir);
        return count;
    }
    
    public int uniquePaths1Helper(int er, int ec, int sr, int sc, int[][] dir)
    {
        if(sr==er && sc==ec)
        {
            return 1;
        }
        
        int count = 0;
        for(int[] d:dir)
        {
            int r = sr+d[0], c = sc+d[1];
            if(r>=0 && c>=0 && r<er+1 && c<ec+1)
            {
                count+=uniquePaths1Helper(er, ec, r, c, dir);
            }
        }
        return count;
    }
    
    public int uniquePathsHelper_Memo(int er, int ec, int sr, int sc,int[][] dp, int[][] dir)
    {
        if(sr==er && sc==ec)
            return dp[sr][sc] = 1;
        
        if(dp[sr][sc]!=0)
            return dp[sr][sc];
        
        int count = 0;
        for(int[] d:dir)
        {
            int r = sr+d[0], c = sc+d[1];
            if(r>=0 && c>=0 && r<dp.length && c<dp[0].length)
            {
                count+=uniquePathsHelper_Memo(er, ec, r, c, dp,dir);
            }
        }
        return dp[sr][sc] = count;
    }
    
    public int uniquePathsHelper_Tab(int SR, int SC, int ER, int EC, int[][] dp, int[][] dir)
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
                    int r = sr+d[0], c=sc+d[1];
                    if(r>=0 && c>=0 && r<dp.length && c<dp[0].length)
                    {
                        count += dp[r][c];
                    }
                }
                dp[sr][sc] = count;
            }
        }
        return dp[SR][SC];
    }
}
