class Solution {
    public int maxProfit(int[] prices) {
        int n  = prices.length;
        if(n<2)
            return 0;
        int minn = prices[0];
        int profit = 0;
        for(int i=1;i<n;i++)
        {
            minn = Math.min(minn, prices[i]);
            profit = Math.max(profit, prices[i]-minn);
        }
        return profit;
    }
}