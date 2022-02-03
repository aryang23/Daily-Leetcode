class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
		// boolean ans = isScramble(s1,s2, 0, 0, s1.length(), new Boolean[n][n][n+1]);
        boolean ans = isScrambleTabu(s1, s2);
        return ans;
    }
    
    public static boolean isScramble(String s1, String s2, int si1, int si2, int len, Boolean[][][] dp) {
	    if(s1.substring(si1, si1+len).equals(s2.substring(si2, si2+len))) {
	        return true;
	    }
	    
	    if(dp[si1][si2][len] != null) {
	        return dp[si1][si2][len];
	    }
	    
	    for(int cp=1; cp<len; cp++) {
	        if((isScramble(s1, s2, si1, si2, cp, dp) && isScramble(s1, s2, si1+cp, si2+cp, len-cp, dp) ) || (isScramble(s1, s2, si1, si2+len-cp, cp, dp) && isScramble(s1, s2, si1+cp, si2, len-cp, dp)) ) {
	            dp[si1][si2][len] = true;
	            return true;
	        } 
	    }
	    
	    dp[si1][si2][len] = false;
	    return false;
	}
    
    public static boolean isScrambleTabu(String s1, String s2) {
	    if(s1.equals(s2) == true) {
	        return true;
	    }
	    int n = s1.length();
	    boolean[][][] dp = new boolean[n][n][n+1];
	    
	    for(int len=1; len<=n; len++) {
	        for(int i=0; i<=n-len; i++) {
	            for(int j=0; j<=n-len; j++) {
	                if(len==1) {
	                    if(s1.charAt(i) == s2.charAt(j)) {
	                        dp[i][j][1] = true;
	                    }
	                }
	                 else {
	                        for(int cp=1; cp<len; cp++) {
	                            dp[i][j][len] = ((dp[i][j][cp] && dp[i+cp][j+cp][len-cp]) || (dp[i][j+len-cp][cp] && dp[i+cp][j][len-cp]));
	                            if(dp[i][j][len] == true)
	                            break;
	                        }
	                    }
	            }
	        }
	    }
	    return dp[0][0][n];
	}
}