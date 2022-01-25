// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public int editDistance(String s, String t) {
        // Code here
        int ans = editDistTab(s, t);
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