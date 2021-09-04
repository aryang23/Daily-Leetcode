class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        // int ans = longestCommonSubsequenceHelper(text1, text2, 0, 0);
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n+1][m+1];
        // int ans = longestCommonSubsequenceMemo(text1, text2, 0, 0,dp);
        // int ans = longestCommonSubeqTab(text1, text2, 0, 0, dp);
        int ans = longestCommonSubseqTab2(text1, text2, n, m, dp);
        return ans;
    }
    public int longestCommonSubsequenceHelper(String text1, String text2, int i, int j)
    {
        if(i==text1.length() || j==text2.length())
            return 0;
        
        int ans = 0;
        if(text1.charAt(i)==text2.charAt(j))
            ans = 1+longestCommonSubsequenceHelper(text1, text2, i+1, j+1);
        else
        {
            int a1 = longestCommonSubsequenceHelper(text1, text2, i+1, j);
            int a2 = longestCommonSubsequenceHelper(text1, text2, i, j+1);
            ans = Math.max(a1, a2);
        }
        return ans;
    }
    
    public int longestCommonSubsequenceMemo(String text1, String text2, int i, int j, int[][] dp)
    {
        if(i==text1.length() || j==text2.length())
            return dp[i][j]=0;
        
        if(dp[i][j]!=0)
            return dp[i][j];
        
        int ans = 0;
        if(text1.charAt(i)==text2.charAt(j))
            ans = 1+longestCommonSubsequenceMemo(text1, text2, i+1, j+1,dp);
        else
        {
            int a1 = longestCommonSubsequenceMemo(text1, text2, i+1, j,dp);
            int a2 = longestCommonSubsequenceMemo(text1, text2, i, j+1,dp);
            ans = Math.max(a1, a2);
        }
        return dp[i][j]=ans;
    }
    
    public int longestCommonSubeqTab(String text1, String text2, int I, int J, int[][] dp)
    {
        int n = text1.length(), m = text2.length();
        for(int i=n;i>=0;i--)
        {
            for(int j=m;j>=0;j--)
            {
                if(i==n || j==m)
                {
                    dp[i][j]=0;
                    continue;
                }

                int ans = 0;
                if(text1.charAt(i)==text2.charAt(j))
                    ans = 1+dp[i+1][j+1];
                else
                {
                    int a1 = dp[i+1][j];
                    int a2 = dp[i][j+1];
                    ans = Math.max(a1, a2);
                }
                dp[i][j]=ans;
            }
        }
        return dp[I][J];
    }
    
    public int longestCommonSubseqTab2(String text1, String text2, int N, int M, int[][] dp)
    {
        for(int n=0;n<=N;n++)
        {
            for(int m=0;m<=M;m++)
            {
                if(n==0 || m==0)
                {
                    dp[n][m] = 0;
                    continue;
                }
                
                int ans = 0;
                if(text1.charAt(n-1) == text2.charAt(m-1))
                    ans = 1 + dp[n-1][m-1];
                else
                {
                    int a1 = dp[n-1][m];
                    int a2 = dp[n][m-1];
                    ans = Math.max(a1, a2);
                }
                dp[n][m] = ans;
            }
        }
        return dp[N][M];
    }
}
