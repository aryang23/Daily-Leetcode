class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
//         int[] dp = new int[n];
//         dp[0] = nums[0];
        
//         int max = dp[0];
//         for(int i=1; i<n ;i++) {
//             dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
//             max = Math.max(max, dp[i]);
//         }
        
        int prev = nums[0];
        int curr = 0;
        int max = prev;
        for(int i=1;i<n;i++) {
            curr = Math.max(nums[i], prev + nums[i]);
            max = Math.max(max, curr);
            prev = curr;
        }
        
        return max;
    }
}