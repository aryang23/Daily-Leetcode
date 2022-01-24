class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int ans = lcsTab(text1, text2);
        return ans;
    }
    public static int lcsTab(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        
        int[][] dp = new int[n+1][m+1];
        
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=m; j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                } else if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[n][m];
    }
}