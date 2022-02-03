class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
		boolean ans = isScramble(s1,s2, 0, 0, s1.length(), new Boolean[n][n][n+1]);
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
}