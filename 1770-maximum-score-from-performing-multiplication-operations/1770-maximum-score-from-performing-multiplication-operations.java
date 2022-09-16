class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        // int ans = maxScore(nums, multipliers, 0, n-1, 0);
        int[][] dp = new int[m][n];
        int ans = maxScore(nums, multipliers, 0, n-1, 0, dp);
        return ans;
    }
    
    public int maxScore(int[] nums, int[] muls, int i1, int i2, int i3) {
        if(i3==muls.length-1) {
            // System.out.println(nums[i1]+",,"+nums[i3]);
            return Math.max(nums[i1]*muls[i3], nums[i2]*muls[i3]);
        }
        int a1 = (nums[i1] * muls[i3]) + maxScore(nums, muls, i1+1, i2, i3+1);
        int a2 = (nums[i2] * muls[i3]) + maxScore(nums, muls, i1, i2-1, i3+1);
        return Math.max(a1, a2);
    }
    
    public int maxScore(int[] nums, int[] muls, int i1, int i2, int i3, int[][] dp) {
        if(i3==muls.length-1) {
            // System.out.println(nums[i1]+",,"+nums[i3]);
            return dp[i3][i1] = Math.max(nums[i1]*muls[i3], nums[i2]*muls[i3]);
        }
        if(dp[i3][i1] != 0) {
            return dp[i3][i1];
        }
        int a1 = (nums[i1] * muls[i3]) + maxScore(nums, muls, i1+1, i2, i3+1, dp);
        int a2 = (nums[i2] * muls[i3]) + maxScore(nums, muls, i1, i2-1, i3+1, dp);
        return dp[i3][i1] = Math.max(a1, a2);
    }
}