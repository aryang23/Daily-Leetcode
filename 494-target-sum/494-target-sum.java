class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, sum=0;
        for(int num:nums)
            sum+=num;
        
        if(target > sum || target < -sum)
            return 0;
        
        // int[][] dp = new int[n+1][target+1];
        // for(int[] d:dp)
        //     Arrays.fill(d, -1);
        
        int[][] dp = new int[n+1][2*sum+1];
        for(int[] d:dp)
            Arrays.fill(d, -1);
        
        
        // int ans = targetSum(nums, n, target);
        int ans = findTargetSumWays(nums, n, sum, sum+target, dp);
        return ans;
    }
    public static int targetSum(int[] arr, int n, int tar)
    {
        if(n==0)
            return (tar==0 ? 1 : 0);
        
        int count = 0;
        count += targetSum(arr, n-1, tar-arr[n-1]);
        count += targetSum(arr, n-1, tar+arr[n-1]);
        return count;
    }
    
    public int findTargetSumWays(int[] nums, int n, int sum, int target, int[][] dp)
    {
        if(n==0)
        {
            return dp[n][sum] = target==sum?1:0;
        }
        int count = 0;
        count += findTargetSumWays(nums, n-1, sum+nums[n-1], target, dp);
        count += findTargetSumWays(nums, n-1, sum-nums[n-1], target, dp);
        
        return dp[n][sum] = count;
    }
    
    
}