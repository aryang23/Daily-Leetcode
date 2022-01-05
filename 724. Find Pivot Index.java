class Solution {
    public int pivotIndex(int[] nums) {
        int tsum = 0;
        for(int val : nums)
            tsum += val;
        
        int lsum = 0;
        
        for(int i=0;i<nums.length;i++)
        {
            tsum -= nums[i];
            if(lsum == tsum)
                return i;
            lsum += nums[i];
        }
        return -1;
    }
}
