// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int l = sc.nextInt();
            int n = sc.nextInt();
            
            int arr[] =  new int[l];
            
            for(int i = 0;i<l;i++)
                arr[i] = sc.nextInt();
            
            Solution ob = new Solution();
                
            if(ob.findPair(arr, l, n)==true)
                System.out.println(1);
                
            else
                System.out.println(-1);    
                
        }
        
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean findPair(int arr[], int size, int target)
    {
        //code here.
        Arrays.sort(arr);
        
        int n = arr.length;
        int lo = 0, hi = 1;
        while(hi < n)
        {
            int diff = arr[hi] - arr[lo];
            if(diff == target){
                // System.out.println(arr[lo]+" "+arr[hi]);
                return true;
            }
            else if(diff > target)
            lo++;
            else
            hi++;
        }
        // System.out.println(-1);
        return false;
    }
}