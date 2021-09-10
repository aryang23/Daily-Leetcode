class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n+1][m+1];
        for(int[] d:dp)
            Arrays.fill(d, -1);
        // int ans = maxUncrossedLinesHelper(nums1, nums2, n, m, dp );
        int ans = maxUncrossedLinesHelperTabu(nums1, nums2, n, m, dp);
        return ans;
    }
    public int maxUncrossedLinesHelper(int[] nums1, int[] nums2, int n, int m, int[][] dp)
    {
        if(n==0 || m==0)
            return dp[n][m] = 0;
        
        if(dp[n][m] != -1)
            return dp[n][m];
        
        int count = 0;
        if(nums1[n-1]==nums2[m-1])
        {
            count = 1 + maxUncrossedLinesHelper(nums1, nums2, n-1, m-1, dp);
        }
        else
        {
            count = Math.max(maxUncrossedLinesHelper(nums1, nums2, n-1, m, dp), maxUncrossedLinesHelper(nums1, nums2, n, m-1, dp));
        }
        return dp[n][m] = count;
    }
    
    public int maxUncrossedLinesHelperTabu(int[] nums1, int[] nums2, int N, int M, int[][] dp)
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

                int count = 0;
                if(nums1[n-1]==nums2[m-1])
                {
                    count = 1 + dp[n-1][m-1];
                }
                else
                {
                    count = Math.max(dp[n-1][m], dp[n][m-1]);
                }
                dp[n][m] = count;
            }
        }
        return dp[N][M];
    }
}
