class Solution {
    public boolean isMatch(String s, String p) {
        p = removeStars(p);
        int n = s.length(), m = p.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] d:dp)
            Arrays.fill(d, -1);
        
        int ans = isMatch(s, p, n, m, dp);
        // int ans = isMatchTab(s, p, n, m, dp);
        return ans == 1;
    }
    
    public String removeStars(String str)
    {
        if(str.length() == 0)
            return str;
        
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        
        int i = 1;
        while (i < str.length())
        {
            while(i<str.length() && sb.charAt(sb.length()-1)=='*' && str.charAt(i)=='*')
            {
                i++;
            }
            
            if(i<str.length())
                sb.append(str.charAt(i));
            i++;
        }
        return sb.toString();
    }
    
    public int isMatch(String s, String p, int n, int m, int[][] dp)
    {
        if(n==0 || m==0)
        {
            if(n==0 && m==0)
                return dp[n][m] = 1;
            else if(m==1 && p.charAt(m-1)=='*')
                dp[n][m] = 1;
            else
                dp[n][m] = 0;
        }
        
        if(dp[n][m] != -1)
            return dp[n][m];
        
        char ch1 = s.charAt(n-1);
        char ch2 = p.charAt(m-1);
        if(ch1==ch2 || ch2=='?')
            return dp[n][m] = isMatch(s, p, n-1, m-1, dp);
        else if(ch2 == '*')
        {
            boolean res = false;
            res = res || isMatch(s, p, n-1, m, dp) == 1;
            res = res || isMatch(s, p, n, m-1, dp) == 1;
            return dp[n][m] = res ? 1 : 0;
        }
        else
            return dp[n][m] = 0;
    }
    
    public int isMatchTab(String s, String p, int N, int M, int[][] dp)
    {
        for(int n=0;n<=N;n++)
        {
            for(int m=0;m<=M;m++)
            {
                if(n==0 || m==0)
                {
                    if(n==0 && m==0)
                    {
                        dp[n][m] = 1;
                        continue;
                    }
                    else if(m==1 && p.charAt(m-1)=='*')
                    {
                        dp[n][m] = 1;
                        continue;
                    }
                    else
                    {
                        dp[n][m] = 0;
                        continue;
                    }
                }

                char ch1 = s.charAt(n-1);
                char ch2 = p.charAt(m-1);
                if(ch1==ch2 || ch2=='?')
                    dp[n][m] = dp[n-1][m-1];
                else if(ch2 == '*')
                {
                    boolean res = false;
                    res = res || dp[n-1][m] == 1;
                    res = res || dp[n][m-1] == 1;
                    
                    dp[n][m] = res ? 1 : 0;
                }
                else
                    dp[n][m] = 0;
            }
        }
        return dp[N][M];
    }
}
