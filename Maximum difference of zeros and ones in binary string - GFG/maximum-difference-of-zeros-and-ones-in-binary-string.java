// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.maxSubstring(s));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int maxSubstring(String str) {
        // code here
        int n = str.length();
        
        int[] dp = new int[n];
        
        int numZero = str.charAt(0)-'0';
        dp[0] = numZero > 0 ? -1 : 1 ;
        int maxx = dp[0];
        for(int i=1;i<n;i++) {
            int num = str.charAt(i)-'0';
            int fNum = num>0? -1: 1;
            dp[i] = Math.max(dp[i-1]+fNum, fNum);
            
            maxx = Math.max(dp[i], maxx);
        }
		return maxx;
    }
}