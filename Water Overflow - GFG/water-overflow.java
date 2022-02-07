// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int K = Integer.parseInt(S[0]);
            int R = Integer.parseInt(S[1]);
            int C = Integer.parseInt(S[2]);

            Solution ob = new Solution();
            System.out.printf("%.6f\n" , ob.waterOverflow(K,R,C));
        }
    }
}// } Driver Code Ends


class Solution {
    static double waterOverflow(int k, int r, int c) {
        // code here
        double[][] dp = new double[k+1][k+1];
      dp[0][0] = k;
      
      for(int i=0; i<dp.length; i++) {
          for(int j=0; j<=i; j++) {
              if(dp[i][j] > 1.0) {
                  double rem = (dp[i][j]-1);
                  dp[i][j] = 1.0;
                  dp[i+1][j] += rem/2.0;
                  
                  dp[i+1][j+1] += rem/2.0;
              }
          }
      }
      return dp[r-1][c-1];
    }
}