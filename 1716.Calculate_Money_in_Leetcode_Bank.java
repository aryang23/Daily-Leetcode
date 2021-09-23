class Solution {
    public int totalMoney(int n) {
        int ans = 0;
        int i=0;
        int money = 1, prevMoney = 1;
        while(n-->0)
        {
            if(i==7)
            {
                i=0;
                prevMoney++;
                money = prevMoney;
            }
            ans += money;
            money++;
            i++;
        }
        return ans;
    }
}
