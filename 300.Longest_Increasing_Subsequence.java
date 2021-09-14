class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxLen = 0;
        // for(int i=0;i<nums.length;i++)
        // {
        //     maxLen = Math.max(maxLen, LIS_Memo(nums, i, dp));
        // }
        // return maxLen;
        int ans = lengthOfLISLR(nums, 0, dp);
        return ans;
    }
    public static int LIS_Memo(int[] arr, int ei, int[] dp)
    {
        if(dp[ei]!=0)
            return dp[ei];
        
        int maxLen = 1;
        for(int i=ei-1;i>=0;i--)
        {
            if(arr[i]<arr[ei])
            {
                int recLen = LIS_Memo(arr, i, dp);
                maxLen = Math.max(maxLen, recLen+1);
            }
        }
        return dp[ei] = maxLen;
    }
    
    public int lengthOfLISLR(int[] nums, int idx,int[] dp)
    {
        dp[0] = 1;
        int maxx = 0;
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            dp[i] = 1;
            for(int j=i-1;j>=0;j--)
            {
                if(nums[i]>nums[j])
                dp[i] = Math.max(dp[i], dp[j]+1);
            }
            maxx = Math.max(maxx, dp[i]);
        }
        return maxx;
    }
    
    
}
