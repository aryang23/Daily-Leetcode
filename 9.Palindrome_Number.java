class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        
        int rnum = reverse(x);
        if(x==rnum)
            return true;
        return false;
        
    }
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
