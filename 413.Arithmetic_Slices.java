class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        int[] dp = new int[arr.length];
        int ans = 0;
        
        for(int i=2;i<arr.length;i++)
        {
            if(arr[i]-arr[i-1] == arr[i-1]-arr[i-2])
            {
                dp[i] = dp[i-1]+1;
                ans += dp[i];
            }
        }
        return ans;
    }
}
