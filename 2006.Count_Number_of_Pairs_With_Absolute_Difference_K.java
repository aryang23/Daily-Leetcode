class Solution {
    public int countKDifference(int[] nums, int k) {
        int count = 0, n = nums.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(Math.abs(nums[i]-nums[j]) == k)
                    count++;
            }
        }
        return count;
    }
    
}
