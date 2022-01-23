class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        
        dp[1] = 1;
        
        int ptr2 = 1;
        int ptr3 = 1;
        int ptr5 = 1;
        for(int i=2; i<=n; i++) {
            int min = Math.min(2*dp[ptr2], Math.min(3*dp[ptr3], 5*dp[ptr5]));
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