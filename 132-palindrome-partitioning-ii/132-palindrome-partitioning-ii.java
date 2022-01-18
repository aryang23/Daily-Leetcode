class Solution {
    public int minCut2(String s) {
        int n = s.length();
		
		boolean[][] dp = new boolean[n][n];
        int count = 0;
        for(int gap = 0;gap<n;gap++) {
            for(int si=0, ei=gap;ei<n;si++, ei++) {
                if(gap==0)
                dp[si][ei] = true;
                else if(gap == 1 && s.charAt(si) == s.charAt(ei))
                dp[si][ei] = true;
                else {
                    if(s.charAt(si) == s.charAt(ei))
                    dp[si][ei] = dp[si+1][ei-1];
                }
            }
        }
        
        int[][] dp2 = new int[n][n];
        
        for(int gap=1; gap<n; gap++) {
           for(int si=0, ei=gap; ei<n; si++, ei++) {
               if(dp[si][ei] == true) {
                   dp2[si][ei] = 0;
               } else {
                   int min = Integer.MAX_VALUE;
                   for(int cp = si; cp < ei; cp++) {
                       min = Math.min(min, dp2[si][cp] + dp2[cp+1][ei] + 1);
                   }
                   dp2[si][ei] = min;
               }
           }
        }
		return dp2[0][n-1];
    }
    
    public int minCut(String s) {
        int n = s.length();
		
		boolean[][] dp = new boolean[n][n];
        int count = 0;
        for(int gap = 0;gap<n;gap++) {
            for(int si=0, ei=gap;ei<n; si++, ei++) {
                if(gap==0)
                dp[si][ei] = true;
                else if(gap == 1 && s.charAt(si) == s.charAt(ei))
                dp[si][ei] = true;
                else {
                    if(s.charAt(si) == s.charAt(ei))
                    dp[si][ei] = dp[si+1][ei-1];
                }
            }
        }
        
        int[] dp2 = new int[n];
        dp2[0] = 0; 
        
        for(int i=1; i<n; i++) {
            if(dp[0][i] == true)
            dp2[i] = 0;
            else {
                dp2[i] = Integer.MAX_VALUE;
                for(int j = i;j > 0; j--) {
                    if(dp[j][i] == true)
                    dp2[i] = Math.min(dp2[i], dp2[j-1] + 1);
                }
            }
        }
        
        return dp2[n-1];
    }
}