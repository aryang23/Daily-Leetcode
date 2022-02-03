class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        int n = arr.length;
        if(n<3)
            return 0;
		int[] dp = new int[n];
		dp[0] = dp[1] = 0;
		int sum = 0;
		for(int i=2; i<n; i++) {
		    if(arr[i]-arr[i-1] == arr[i-1] - arr[i-2])
		    dp[i] = dp[i-1] + 1;
		    
		    sum += dp[i];
		} 
		return sum;
    }
}