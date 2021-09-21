class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxx = 0;
        int i=0, n = nums.length;
        while(i<n)
        {
            int count = 0;
            if(nums[i]==1)
            {
                count++;
                i++;
                while(i<n && nums[i]==1)
                {
                    count++;
                    i++;
                }
                maxx = Math.max(maxx, count);
            }
            else
                i++;
        }
        return maxx;
    }
}
