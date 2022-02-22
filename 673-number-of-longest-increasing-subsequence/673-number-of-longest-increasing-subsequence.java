class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, maxLen = 0, maxCount = 0;
        int[] dp = new int[n];
        int[] count = new int[n];
        
        for(int i=0; i<n; i++) {
            dp[i] = 1;
            count[i] = 1;
            
            for(int j=i-1; j>=0; j--) {
                if(nums[i] > nums[j]) {
                    if(dp[i] < dp[j]+1) {
                        dp[i] = dp[j]+1;
                        count[i]  = count[j];
                    } else if(dp[i] == dp[j]+1) {
                        count[i] +=  count[j];
                    }
                }
            }
            if(dp[i] > maxLen) {
                maxLen = dp[i];
                maxCount = count[i];
            } else if(dp[i] == maxLen) {
                maxCount += count[i];   
            }
        }
        return maxCount;
    }
}