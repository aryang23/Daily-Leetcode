// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int n, int arr[])
    {
        // code here
        int[][] dp = new int[n][n];
	    
	    for(int gap=0;gap<n;gap++)
	    {
	        for(int i=0,j=gap;j<n;i++, j++)
	        {
	            if(i==j || i+1 == j){
	                dp[i][j] = 0;
	            } else {
	                int ans = Integer.MAX_VALUE;
	                for(int cut=i+1;cut<j;cut++)
	                {
	                    ans = Math.min(ans, dp[i][cut]+dp[cut][j]+arr[i]*arr[cut]*arr[j]);
	                }
	                dp[i][j] = ans;
	            }
	        }
	    }
	    
	    return dp[0][n-1];
    }
}