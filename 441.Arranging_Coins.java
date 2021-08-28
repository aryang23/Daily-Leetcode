class Solution {
    public int arrangeCoins(int n) {
        int i = 1;
        int k = 0;
        while(n>=i)
        {
            n-=i;
            i++;
            k++;
        }
        return k;
    }
}

