class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        return combinationSum4_tabu(nums, target, dp);
    }
    public int combinationSum4_tabu(int[] arr, int TARGET, int[] dp)
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
                if(target-ele >= 0)
                    count += dp[target-ele]; 
            }
            dp[target] = count;
        }
        return dp[TARGET];
    }
}
