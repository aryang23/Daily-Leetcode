class Solution {
    public int largestUniqueNumber(int[] nums) {
        Arrays.sort(nums);
        
        for(int i=nums.length-1;i>=0;i--)
        {
            if(i==0 || nums[i]!=nums[i-1])
                return nums[i];
            
            while(i>0 && nums[i]==nums[i-1])
                i--;
        }
        return -1;
    }
}
