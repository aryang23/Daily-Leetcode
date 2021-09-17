class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        int ans = comb4_memo(nums, target, dp);
        // int ans = comb4_tabu(nums, target, dp);
        return ans;
    }
    
    public int comb4_memo(int[] arr, int target, int[] dp)
    {
        if(target==0)
            return dp[target] = 1;
        if(dp[target]!=-1)
            return dp[target];
        
        int count = 0;
        for(int ele:arr)
        {
            if(target-ele>=0)
                count += comb4_memo(arr, target-ele, dp);
        }
        return dp[target] = count;
    }
    public int comb4_tabu(int[] arr, int TARGET, int[] dp)
    {
        for(int target=0;target<=TARGET;target++)
        {
            if(target==0)
            {
                dp[target] = 1;
                continue;
            }

            int count = 0;
            for(int ele:arr)
            {
                if(target-ele>=0)
                    count += dp[target-ele];
            }
            dp[target] = count;
        }
        return dp[TARGET];
    }
}
