class Solution {
    public double myPow(double x, long n) {
        
        if(n==0)
            return 1;
        
        if(n<0)
        {
            x = 1/x;
            n = -n;
        }
        
        double ans = myPow(x, n/2);
        ans=ans*ans;
        // ans = n%2 ? ans * x : ans;
        if(n%2==1)
            ans*=x;
        
        return ans;
        
    }
}
