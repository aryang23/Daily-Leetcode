class Solution {
    public int reverse(int x) {
        long ans = 0;
        while(x!=0)
        {
            int sn = x%10;
            ans = ans*10+sn;
            x = x/10;
        }
        return (int)ans == ans ? (int)ans : 0;
    }   
}
