class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int[] dp = new int[envelopes.length];
        return maximumBridge(envelopes, dp);
    }
    public static int maximumBridge(int[][] arr,int[] dp)
    {
        Arrays.sort(arr, (a,b)->{
            return a[1]-b[1];
        });
        int n = arr.length, maxLen = 0;
        for(int i=0;i<n;i++)
        {
            dp[i] = 1;
            for(int j=i-1;j>=0;j--)
            {
                if(arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1])
                {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
