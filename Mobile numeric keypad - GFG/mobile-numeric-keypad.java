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
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.getCount(n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
	public long getCount(int n)
	{
		// Your code goes here
				
		HashMap<Integer, int[]> map = new HashMap<>();
		map.put(0, new int[]{0, 8});
		map.put(1, new int[]{1, 2, 4});
		map.put(2, new int[]{1, 2, 3, 5});
		map.put(3, new int[]{2, 3, 6});
		map.put(4, new int[]{1, 4, 5, 7});
		map.put(5, new int[]{2, 4, 5, 6, 8});
		map.put(6, new int[]{3, 5, 6, 9});
		map.put(7, new int[]{4, 7, 8});
		map.put(8, new int[]{0, 5, 7, 8, 9});
		map.put(9, new int[]{6, 8, 9});
		
		
		long[][] dp = new long[n+1][10];
		
		
		
		for(int i=1; i<=n; i++) {
		    for(int j=0; j<10; j++) {
		        if(i==1) {
		            dp[i][j] = 1;
		        } else {
		            int[] list = map.get(j);
		            for(int k=0; k<list.length; k++) {
		                dp[i][j] += (long)(dp[i-1][list[k]]);
		            }
		        }
		    }
		}
		
		long ans = 0;
		for(int j=0; j<10; j++) {
		    ans += (long)(dp[n][j]);
		  //  System.out.print(dp[n][j]+" ");
		}
		return ans;
	}
}