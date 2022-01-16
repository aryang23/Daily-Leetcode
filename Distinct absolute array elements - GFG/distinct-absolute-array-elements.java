// { Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().distinctCount(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java




class Solution {
    int distinctCount(int[] arr, int n) {
        // code here
        int count = 0;
    int left = 0;
    int right = arr.length - 1;
    int prev = Integer.MIN_VALUE;
    int next = Integer.MAX_VALUE;
        
    while(left <= right) {
        int lval = Math.abs(arr[left]);
        int rval = Math.abs(arr[right]);
        
        if(lval == rval) {
            if(lval != prev && rval != next) {
                count++;
            }
            prev = lval;
            left++;
            
            next = rval;
            right--;
        } else if(lval > rval) {
            if(lval != prev) 
                count++;
            prev = lval;
            left++;
        } else {
            if(rval != next)
                count++;
            next = rval;
            right--;
        }
        
    }
    return count;
    }
}
