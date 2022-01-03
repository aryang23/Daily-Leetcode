class Solution {
    public boolean isArmstrong(int n) {
        int ans = 0;
        int N = n;
        int td = (int)Math.floor(Math.log10(n) + 1); 

        while(n>0)
        {
            int ld = n%10;
            n /= 10;
            ans += Math.pow(ld, td);
            // System.out.println(ans);
        }
        // System.out.println(ans);
        return (N==ans)?true:false;
    }
}
