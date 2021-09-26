class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                ans = Math.max(ans, nums[j]-nums[i]);
            }
        }
        return ans==0?-1:ans;
    }
}
