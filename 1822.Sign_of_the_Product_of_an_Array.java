class Solution {
    public int arraySign(int[] nums) {
        int ans = 1;
        for(int num:nums)
        {
            if(num==0)
                return 0;
            ans*=(num>0)?1:-1;
        }
        return ans>0?1:-1;
    }
}
