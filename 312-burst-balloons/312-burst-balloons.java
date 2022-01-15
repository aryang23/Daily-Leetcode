class Solution {
    public int maxCoins(int[] arr) {
        int n = arr.length;
    int[][] dp = new int[n][n];
    
    for(int gap=0;gap<n;gap++)
    {
        for(int si=0, ei=gap; ei<n; si++, ei++) {
            if(gap == 0){
                dp[si][ei] = (si>=1?arr[si-1]:1) * arr[si] * (si+1<n?arr[si + 1] : 1);
            } else {
                int max = Integer.MIN_VALUE;
                for(int cp = si;cp <= ei;cp++)
                {
                    int lAns = cp-1>=0?dp[si][cp-1]:0;
                    int rAns = cp+1<n?dp[cp+1][ei]:0;
                    int currCost = (si-1>=0?arr[si-1]:1) * arr[cp] * (ei+1<n?arr[ei+1]:1);
                    
                    max = Math.max(max, lAns + rAns + currCost);
                    
                }
                dp[si][ei] = max;
            }
        }
    }
    return dp[0][n-1];
    }
}