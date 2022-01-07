// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findMin(A, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findMin(int arr[], int n)
    {
        //complete the function here
        int lo = 0;
        int hi = arr.length - 1;
        while(lo < hi)
        {
            int mid = lo + (hi-lo)/2;
            if(arr[mid] < arr[hi]){
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return arr[hi];
    }
}
