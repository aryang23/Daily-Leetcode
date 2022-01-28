// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String X = sc.next();
                    String Y = sc.next();
                    int costX = sc.nextInt();
                    int costY = sc.nextInt();
                    
                   
                    Solution ob = new Solution();
                    System.out.println(ob.findMinCost(X,Y,costX,costY));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
    
    public static int lcsTab2(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        
        int[][] dp = new int[n+1][m+1];
        
        for(int i=n-1; i>=0; i--) {
            for(int j=m-1; j>=0; j--) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
    
	public int findMinCost(String s1, String s2, int c1, int c2)
	{
		// Your code goes here
		int lcs = lcsTab2(s1, s2);
        int ans = (s1.length() - lcs)*c1 + (s2.length()-lcs)*c2;
		return ans;
	}
}
