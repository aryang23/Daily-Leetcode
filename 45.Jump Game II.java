class Solution {
    public int jump(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[n-1] = 0;
        
        for(int i=n-2;i>=0;i--)
        {
            int min = Integer.MAX_VALUE;
            for(int jump = 1;jump <= arr[i] && i+jump<n;jump++)
            {
                min = Math.min(dp[i+jump], min);
            }
            if(min!=Integer.MAX_VALUE)
                dp[i] = min + 1;
            else
                dp[i] = min;
        }
        
        return dp[0];
    }
}
