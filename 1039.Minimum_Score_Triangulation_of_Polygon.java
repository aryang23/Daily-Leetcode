class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        return minScoreTriangulation(values, 0, n-1, dp);
    }
    public int minScoreTriangulation(int[] values, int si, int ei, int[][] dp)
    {
        if(ei-si<2)
            return dp[si][ei] = 0;
        
        if(dp[si][ei]!=0)
            return dp[si][ei];
        
        int minRes = (int)1e9;
        for(int cut=si+1;cut<ei;cut++)
        {
            int leftRes = minScoreTriangulation(values, si, cut, dp);
            int rightRes = minScoreTriangulation(values, cut, ei, dp);
            
            minRes = Math.min(minRes, leftRes + values[si]*values[cut]*values[ei]+rightRes);
        }
        return dp[si][ei] = minRes;
    }
}
