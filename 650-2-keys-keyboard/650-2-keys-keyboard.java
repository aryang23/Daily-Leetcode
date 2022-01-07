class Solution {
    public int minSteps(int n) {
        int ans = 0;
        for(int div = 2;div*div <= n;div++)
        {
            while(n%div == 0)
            {
                n = n / div;
                ans += div;
            }
        }
        
        if(n!=1)
            ans += n;
        
        return ans;
    }
}