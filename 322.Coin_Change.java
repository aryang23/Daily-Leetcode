class Solution {
    public int coinChange(int[] arr, int Tar) {
        int[] dp = new int[Tar+1];
        Arrays.fill(dp, (int) 1e9);
        dp[0] =0;
        for(int tar=1;tar<=Tar;tar++)
        {
            for(int ele:arr)
            {
                if(tar-ele >= 0)
                    dp[tar] = Math.min(dp[tar], dp[tar-ele]+1);
            }
        }
        return dp[Tar]!=(int)1e9 ? dp[Tar] : -1;
    }
}
