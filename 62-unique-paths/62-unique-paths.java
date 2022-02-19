class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        int[][] dir = {{1, 0},{0,1}};
        // int count = uniquePathsHelper_Memo(0, 0, m-1, n-1, dir, dp);
        int count = uniquePathsHelper_Tab(0, 0, m-1, n-1, dp, dir);
        return count;
    }
    
    public static int uniquePathsHelper_Memo(int sr, int sc, int er, int ec, int[][] dir, int[][] dp)
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
                count += uniquePathsHelper_Memo(r, c, er, ec, dir, dp);
        }
        return dp[sr][sc] = count;
    }
    
    public static int uniquePathsHelper_Tab(int SR, int SC, int ER, int EC, int[][] dp, int[][] dir)
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
                    int r = sr+d[0], c = sc+d[1];
                    if(r>=0 && c>=0 && r<dp.length && c<dp[0].length)
                        count += dp[r][c];//uniquePathsHelper_Memo(r, c, er, ec, dir, dp);
                }
                dp[sr][sc] = count;
            }
        }
        return dp[SR][SC];
    }
}