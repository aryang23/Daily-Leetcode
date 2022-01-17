class Solution {
    public int minScoreTriangulation(int[] arr) {
        int n = arr.length;
        
        int[][] dp = new int[n][n];
        
        for(int gap=2; gap<n; gap++) {
            for(int si=0, ei=gap; ei<n; si++ , ei++){
                if(gap == 2) {
                    dp[si][ei] = (arr[si] * arr[si+1] * arr[si+2]);
                }
                else {
                    int min = Integer.MAX_VALUE;
                    for(int cut = si + 1; cut < ei; cut++) {
                        min = Math.min(min, dp[si][cut] + dp[cut][ei] + arr[si]*arr[cut]*arr[ei]);
                    }
                    dp[si][ei] = min;
                }
            }
        }
        
        return dp[0][n-1];
    }
}