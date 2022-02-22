class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        
        int[] dp =new int[n];
        
        for(int i=0; i<n; i++) {
            dp[i] = 1;
            if(i>0 && nums[i]>nums[i-1]) {
                dp[i] += dp[i-1];
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}