class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int i = 0 , j = n-1;
        // int ans = longestPalindromeMemo(s, i, j);
        int[][] dp = new int[n][n];
        // int ans = longestPalindromeMemo2(s, i, j, dp);
        int ans = longestPalindromeTab(s, i, j, dp);
        return ans;
    }
    
    public static int longestPalindromeMemo(String s, int i, int j)
    {
        if(i==j)
            return 1;
        if(i>j)
            return 0;
        int ans = 0;
        if(s.charAt(i)==s.charAt(j))
            ans = 2 + longestPalindromeMemo(s, i+1, j-1);
        else
        {
            int op1 = longestPalindromeMemo(s, i+1, j);
            int op2 = longestPalindromeMemo(s, i, j-1);
            ans = Math.max(op1, op2);
        }
        return ans;
    }

    public static int longestPalindromeMemo2(String s, int i, int j, int[][] dp)
    {
        if(i==j)
            return dp[i][j] = 1;
        
        if(i>j)
            return dp[i][j] = 0;
        
        if(dp[i][j]!=0)
            return dp[i][j];
        
        int ans = 0;
        if(s.charAt(i)==s.charAt(j))
            ans = 2 + longestPalindromeMemo2(s, i+1, j-1, dp);
        else
        {
            int op1 = longestPalindromeMemo2(s, i+1, j, dp);
            int op2 = longestPalindromeMemo2(s, i, j-1, dp);
            ans = Math.max(op1, op2);
        }
        return dp[i][j] = ans;
    }
    
    public static int longestPalindromeTab(String s, int I, int J, int[][] dp)
    {
        int n = s.length();
        for(int gap = 0;gap<n;gap++)
        {
            for(int i=0, j=gap;j<n;i++, j++)
            {
                if(i==j)
                {
                    dp[i][j] = 1;
                    continue;
                }
                int ans = 0;
                if(s.charAt(i)==s.charAt(j))
                    ans = 2 + dp[i+1][j-1];
                else
                {
                    int op1 = dp[i+1][j];
                    int op2 = dp[i][j-1];
                    ans = Math.max(op1, op2);
                }
                dp[i][j] = ans;            
            }
        }
        return dp[I][J];
    }
}
