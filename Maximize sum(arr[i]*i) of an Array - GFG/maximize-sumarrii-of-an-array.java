// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a[] = new int[n];
            
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            
            System.out.println(obj.Maximize(a,n));
        }
        
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    
    int Maximize(int arr[], int n)
    {
        // Complete the function
        long sum = 0;
        int mod = (int)1e9 + 7;
        Arrays.sort(arr);
        
        for(long i=0;i<arr.length;i++)
        {
            sum = (sum % mod +  (i * arr[(int)i])%mod)%mod;
        }
        return (int)(sum % mod);
    }   
}

