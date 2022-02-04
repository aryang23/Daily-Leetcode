class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        		HashMap<Long, Integer>[] dp = new HashMap[arr.length];
		for(int i=0; i<dp.length; i++) {
		    dp[i] = new HashMap<>();
		}
		
		int ans = 0;
		for(int i=1; i<arr.length; i++) {
		    for(int j=i-1; j>=0; j--) {
		        long diff = (long)arr[i] - (long)arr[j];
		        if(dp[j].containsKey(diff) == true) {
		            int x = dp[j].get(diff);
		            ans += x;
		            dp[i].put(diff, dp[i].getOrDefault(diff, 0) + x + 1);
		        } else {
		            dp[i].put(diff, dp[i].getOrDefault(diff, 0) + 1);
		        }
		    }
		}
		return ans;

    }
}