// { Driver Code Starts


import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution{
    public int cutRod(int prices[], int n) {
        //code here
        // int n = prices.length;
    
    int[] dp = new int[n+1];
    dp[1] = prices[0];
    // dp[2] = Math.max(prices[1],prices[0]*2);
    for(int i=2; i<=n; i++) {
        dp[i] = prices[i-1];
        for(int j=1;j<=i/2;j++) {
            dp[i] = Math.max(dp[i], dp[j] + dp[i-j]);
        }
    }
    return dp[n];
    }
}