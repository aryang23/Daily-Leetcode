// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    
    static long countInv = 0;
    
    private static long[] mergeSort(long[] arr, int lo, int hi)
    {
        if(lo == hi)
        {
            long[] bres = {arr[lo]};
            return bres;
        }
        
        int mid = lo + (hi - lo ) / 2;
        long[] lres = mergeSort(arr, lo, mid);
        long[] rres = mergeSort(arr, mid+1, hi);
        
        long[] res = mergeSortedArrays(lres, rres);
        return res;
    }
    
    public static long[] mergeSortedArrays(long[] arr1, long[] arr2)
    {
        int n1 = (arr1.length);
        int n2 = (arr2.length);
        
        long[] res = new long[(n1 + n2)];
        
        int i=0, j=0, k=0;
        
        while(i < n1 && j < n2)
        {
            if(arr1[i] > arr2[j])
            {
                res[k++] = arr2[j++];
                countInv += (n1 - i);
            }
            else
            {
                res[k++] = arr1[i++];
            }
        }
        
        while(i < n1)
        {
            res[k++] = arr1[i++];
        }
        
        while(j < n2)
        {
            res[k++] = arr2[j++];
        }
        
        return res;
    }
    
    
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        
        countInv = 0;
        long[] res = mergeSort(arr, 0, arr.length - 1);
        
        return countInv;
    }
}