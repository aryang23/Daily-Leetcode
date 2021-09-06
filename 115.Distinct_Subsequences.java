class Solution {
    public int numDistinct(String s, String t) {
        boolean[] visited = new boolean[s.length()];
        int n = s.length(), m = t.length();
        // int ans = numDistinctRec(s, t, 0, 0, visited);
        // int ans = numDistinctRec2(s, t, 0, 0);
        int[][] dp = new int[n+1][m+1];
        for(int[] d:dp)
            Arrays.fill(d, -1);
        int ans = numDistinctRecMemo(s, t, 0, 0, dp);
        // int ans = numDistinctRecTab(s, t, 0, 0, dp);
        
        
        //Part-2
        // int[][] dp = new int[n+1][m+1];
        // for(int[] d:dp)
        //     Arrays.fill(d, -1);
        // int ans = numDistintMemo2(s, t, n, m, dp);
        // int ans = numDistinctTab2(s, t, n, m, dp);
        
        
        return ans;
    }
    
    
    public int numDistinctRec2(String s, String t, int idx, int tIdx)
    {
        if(tIdx==t.length())
            return 1;
        if(s.length() < t.length() || idx==s.length())
            return 0;
        int ans = 0;
        if(s.charAt(idx)==t.charAt(tIdx))
        {
            ans += numDistinctRec2(s, t, idx+1, tIdx+1);
            ans += numDistinctRec2(s, t, idx+1, tIdx);
        }
        else
        {
            ans += numDistinctRec2(s, t, idx+1, tIdx);
        }
        return ans;
    }
    
    public int numDistinctRecMemo(String s, String t, int idx, int tIdx, int[][] dp)
    {
        if(tIdx==t.length())
            return dp[idx][tIdx] = 1;
        
        if(idx==s.length())
            return dp[idx][tIdx] = 0;
        
        if(dp[idx][tIdx]!=-1)
            return dp[idx][tIdx];
        
        int ans = 0;
        if(s.charAt(idx)==t.charAt(tIdx))
        {
            ans += numDistinctRecMemo(s, t, idx+1, tIdx+1, dp);
            ans += numDistinctRecMemo(s, t, idx+1, tIdx, dp);
        }
        else
        {
            ans += numDistinctRecMemo(s, t, idx+1, tIdx, dp);
        }
        return dp[idx][tIdx] = ans;
    }
    
    public int numDistinctRecTab(String s, String t, int IDX, int TIDX, int[][] dp)
    {
        int n = s.length(), m = t.length();
        for(int idx=n;idx>=0;idx--)
        {
            for(int tIdx=m;tIdx>=0;tIdx--)
            {
                if(tIdx==m)
                {
                    dp[idx][tIdx] = 1;
                    continue;
                }
                
                if(n < m || idx==n)
                {
                    dp[idx][tIdx] = 0;
                    continue;
                }

                int ans = 0;
                if(s.charAt(idx)==t.charAt(tIdx))
                {
                    ans += dp[idx+1][tIdx+1];
                    ans += dp[idx+1][tIdx];
                }
                else
                {
                    ans += dp[idx+1][tIdx];
                }
                dp[idx][tIdx] = ans;
            }
        }
        return dp[IDX][TIDX];
    }
    
    //Reverse to  Forward
    public int numDistintMemo2(String s, String t, int n, int m, int[][] dp)
    {
        if(m==0)
            return dp[n][m] = 1;
        
        if(n < m)
            return dp[n][m] = 0;
        
        if(dp[n][m]!=-1)
            return dp[n][m];
        
        int a = numDistintMemo2(s, t, n-1, m-1, dp);
        int b = numDistintMemo2(s, t, n-1, m, dp);
        if(s.charAt(n-1)==t.charAt(m-1))
            return dp[n][m] = a+b;
        else
            return dp[n][m] = b;
    }
    
    public int numDistinctTab2(String s, String t, int N, int M, int[][] dp)
    {
        for(int n=0;n<=N;n++)
        {
            for(int m=0;m<=M;m++)
            {
                if(m==0)
                {
                    dp[n][m] = 1;
                    continue;
                }

                if(n < m)
                {
                    dp[n][m] = 0;
                    continue;
                }

                int a = dp[n-1][m-1];
                int b = dp[n-1][m];
                if(s.charAt(n-1) == t.charAt(m-1))
                    dp[n][m] = a+b;
                else
                    dp[n][m] = b;
            }
        }
        return dp[N][M];
    }
}
