class Solution {
    public int superPow(int a, int[] b) {
        int res = 0;
        for(int i=0; i<b.length; i++) {
            res = (res*10+b[i]) % 1140;
        }
        return power(a, res, 1337);
    }
    public int power(int a, int b, int M) {
        a %= M;
        int ans = 1;
        if(a==0)
            return 0;
        while(b>0) {
            if(b %2==1) {
                ans = (ans*a)%M;
            }
            a = (a*a)%M;
            b>>>=1;
        }
        return ans;
    }
}