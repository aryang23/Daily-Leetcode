class Solution {
    public int minDistance(String word1, String word2) {
        int ans = editDistTab(word1, word2);
        return ans;
    }
    public static int editDistTab(String str1, String str2) {
	    int n = str1.length(), m = str2.length();
	    int[][] dp = new int[n+1][m+1];
	    
	    for(int i=0; i<=n; i++) {
	        for(int j=0; j<=m; j++) {
	            if(i==0 || j==0) {
	                dp[i][j] = (i==0) ? j : i;
	                continue;
	            }
	            
	            int insert = dp[i][j-1];
	            int remove = dp[i-1][j];
	            int replace = dp[i-1][j-1];
	            if(str1.charAt(i-1) == str2.charAt(j-1)) {
	                dp[i][j] = replace;
	            } else {
	                int ans = Math.min(insert, Math.min(remove, replace));
	            dp[i][j] = ans + 1;
	            }
	        }
	    }
	    return dp[n][m];
	}
}