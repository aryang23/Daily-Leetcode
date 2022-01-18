class Solution {
    public int climbStairs(int n)
    {
        int ans = climbStairsTab3(n);
        return ans;
    }
    public static int climbStairsTab(int n)
    {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++)
        {
            int ans = 0;
            for(int j=1;j<=2;j++)
            {
                if((i-j)>=0)
                {
                    ans+=dp[i-j];
                }
            }
            dp[i] = ans;
        }
        return dp[n];
    }
    
    public static int climbStairsTab3(int n)
    {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++)
        {
            int ans = 0;
            for(int j=1;j<=2;j++)
            {
                if((i-j)>=0)
                    ans+=dp[i-j];
            }
            dp[i]=ans;
        }
        return dp[n];
    }
    public int climbStairsRec(int n)
    {
        if(n==0)
            return 1;
        int ans = 0;
        for(int i=1;i<=2;i++)
        {
            if((n-i)>=0)
            {
                ans+=climbStairs(n-i);
            }
        }
        return ans;
    }
    
    public int climbStairsTab2(int n) {
        int a = 1, b = 1;
        for(int i=2;i<=n;i++)
        {
            int sum = a+b;
            a=b;
            b=sum;
        }
        return b;   
    }
}