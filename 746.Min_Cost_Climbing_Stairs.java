class Solution {
    public int minCostClimbingStairs(int[] cost)
    {
        int n = cost.length;
        // return Math.min(minCost(cost, n-1), minCost(cost, n-2));
        // return Math.min(minCost2(cost, 0), minCost2(cost, 1));
        return minCost2Tab(cost, n);
    }
    
    private int minCost(int[] cost, int n)
    {
        if(n<0)
            return 0;
        if(n==0 || n==1)
            return cost[n];
        return cost[n]+Math.min(minCost(cost, n-1), minCost(cost, n-2));
    }
    
    private int minCost2(int[] cost, int n)
    {
        if(n>=cost.length)
            return 0;
        if(n==cost.length-1 || n==cost.length-2)
            return cost[n];
        
        return cost[n]+Math.min(minCost2(cost, n+1), minCost2(cost, n+2));
    }
    
    private int minCost1Tab(int[] cost)
    {
        int N = cost.length;
        int[] dp = new int[N];
        for(int n=0;n<N;n++)
        {
            if(n<=1){
                dp[n] = cost[n];
                continue;
            }
            
            int ans = Math.min(dp[n-1], dp[n-2])+cost[n];
            dp[n]=ans;
        }
    }
    
    private int minCost2Tab(int[] cost, int N)
    {
        int[] dp= new int[N];
        for(int i=N-1;i>=0;i--)
        {
            if(i==N-1 || i==N-2)
            {
                dp[i]=cost[i];
                continue;
            }
            
            dp[i] = cost[i]+Math.min(dp[i+1],dp[i+2]);
        }
        return Math.min(dp[0],dp[1]);
    }
}
