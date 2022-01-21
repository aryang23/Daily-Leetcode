// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            System.out.println(new Solution().getNthUglyNo(n));
        }
    }
}// } Driver Code Ends


class Solution {
    /* Function to get the nth ugly number*/
    long getNthUglyNo(int n) {
        // code here
        long[] dp = new long[(int)n+1];
      
      dp[1] = 1;
      
      int ptr2 = 1;
      int ptr3 = 1;
      int ptr5 = 1;
      
      for(int i=2;i<=n;i++) {
          long min = Math.min(2*dp[ptr2], Math.min(3*dp[ptr3], 5*dp[ptr5]));
          dp[i] = min;
          if(2*dp[ptr2] == min)
            ptr2++;
          if(3*dp[ptr3] == min)
            ptr3++;
          if(5*dp[ptr5] == min)
            ptr5++;
      }
      
      return dp[n];
    }
}