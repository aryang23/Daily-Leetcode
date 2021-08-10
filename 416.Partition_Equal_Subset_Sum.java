class Solution {
    public boolean canPartition(int[] nums) {
        boolean ans = canPartitionHelper(nums, 1, nums[0], 0);
        return ans;
        
        
    }
    
    public boolean canPartitionHelper(int[] nums, int idx, int sum1, int sum2)
    {
        if(idx==nums.length)
        {
            if(sum1==sum2)
                return true;
            return false;
        }
        boolean sa = canPartitionHelper(nums, idx+1, sum1+nums[idx], sum2);
        if(sa==true)
            return true;
        
        sa = canPartitionHelper(nums, idx+1, sum1, sum2+nums[idx]);
        if(sa==true)
            return true;
        
        return false;
        
    }
}
