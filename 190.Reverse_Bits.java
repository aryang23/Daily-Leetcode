public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
        int ans = 0;
        int temp = n;
        int idx =0;
        while(temp!=0)
        {
            int sb = temp&1;
            temp>>>=1;
            ans=ans|((sb)<<(31-idx));
            idx++;
        }
        return ans;
    }
}
