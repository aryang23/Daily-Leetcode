// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, n, k);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        // code here
        if(n == 0) {
            return -1;
        }
        Arrays.sort(arr);
        int diff = arr[n-1]-arr[0];
        int maxi = Integer.MIN_VALUE, mini = Integer.MAX_VALUE;
        
        for(int i=1; i<n; i++) {
            if(arr[i]-k<0) {
                continue;
            }
            maxi = Math.max(arr[i-1]+k, arr[n-1]-k);
            mini = Math.min(arr[0]+k, arr[i]-k);
            diff = Math.min(maxi-mini, diff);
        }
        return diff;
    }
}
