class Solution {
    public int maxA(int n) {
        int[] dp = new int[n+1];
		for(int i=1;i<=n;i++)
		{
		    if(i <= 6){
		        dp[i] = i;
		    }else {
		        
		        int maxx = i;
		        for(int j=1;j<=i-3;j++)
		        {
		            maxx = Math.max(maxx, dp[j] + dp[j]*(i-j-2));
		        }
		        dp[i] = maxx;
		    }
		}
		return dp[n];
    }
}
