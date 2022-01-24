// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        // int ans = lcs(s1, s2, 0, 0);
        int ans = lcsTab(s1, s2);
        return ans;
    }
    public static int lcs(String s1, String s2, int i, int j) {
        if(i==s1.length() || j==s2.length()) {
            return 0;
        }
        
        int ans = 0;
        if(s1.charAt(i) == s2.charAt(j)) {
            ans = 1 + lcs(s1, s2, i+1, j+1);
        } else {
            ans = Math.max(lcs(s1, s2, i+1, j), lcs(s1, s2, i, j+1));
        }
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