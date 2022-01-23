// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0; i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.offerings(N, arr));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    int offerings(int N, int height[]){
        // code here
        int n = height.length;
		
		int[] dp1 = new int[n];
		int[] dp2 = new int[n];
		
		Arrays.fill(dp1, 1);
		Arrays.fill(dp2, 1);
		
		dp1[0] = dp2[n-1] = 1;
		
		for(int i=1; i<n; i++) {
		    if(height[i] > height[i-1])
		        dp1[i] = dp1[i-1] + 1;
		}
		
		for(int i=n-2; i>=0; i--) {
		    if(height[i] > height[i+1])
		        dp2[i] = dp2[i+1] + 1;
		}
		
		int[] dp = new int[n];
		int sum = 0;
		for(int i=0;i<n;i++) {
		    dp[i] = Math.max(dp1[i], dp2[i]);
		    sum += dp[i];
		}
		
		return sum;
    }
}