class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n+1][m+1];
        for (int[] d : dp)
            Arrays.fill(d, -(int) 1e9);
        
        // int ans = maxDotProductHelper(nums1, nums2, n, m, dp);
        int ans = maxDotProductHelperTabu(nums1, nums2, n, m, dp);
        return ans;
    }
    
    

    public int maxDotProductHelper(int[] nums1, int[] nums2, int n, int m, int[][] dp)
    {
        if(n==0 || m==0)
        return dp[n][m] = -(int)1e8;

        if(dp[n][m] != -(int)1e9)
        return dp[n][m];

        int val = nums1[n-1]*nums2[m-1];
        int acceptBothNumbers = maxDotProductHelper(nums1, nums2, n-1, m-1, dp)+val;
        int a = maxDotProductHelper(nums1, nums2, n-1, m, dp);
        int b = maxDotProductHelper(nums1, nums2, n, m-1, dp);
        int ans = maximum(val, acceptBothNumbers, a, b);

        return dp[n][m] = ans;
    }
    
    public int maxDotProductHelperTabu(int[] nums1, int[] nums2, int N, int M, int[][] dp)
    {
        for(int n=0;n<=N;n++)
        {
            for(int m=0;m<=M;m++)
            {
                if(n==0 || m==0)
                {
                    dp[n][m] = -(int)1e8;
                    continue;
                }

                int val = nums1[n-1]*nums2[m-1];
                int acceptBothNumbers = dp[n-1][m-1]+val;
                int a = dp[n-1][m];
                int b = dp[n][m-1];
                int ans = maximum(val, acceptBothNumbers, a, b);

                dp[n][m] = ans;
            }
        }
        return dp[N][M];
    }

    public int maximum(int... arr)
    {
        int max = arr[0];
        for(int ele:arr)
        max = Math.max(max, ele);

        return max;
    }
}
