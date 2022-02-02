class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
		int m = t.length();
		int[][] dp = new int[m+1][n+1];
		
		for(int j=0; j<=n; j++) {
		    dp[dp.length-1][j] = 1;
		}
		
		for(int i=m-1; i>=0; i--) {
		    for(int j=n-1; j>=0; j--) {
		        if(s.charAt(j)==t.charAt(i)) {
		                dp[i][j] = dp[i+1][j+1]+dp[i][j+1];
		            } else {
		                dp[i][j] = dp[i][j+1];
		            }
		    }
		}
		return dp[0][0];
    }
}