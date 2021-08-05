class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int i = 0;
        for(i=0;i<n;i++)
        {
            ans=ans^i;
            ans=ans^nums[i];
        }
        ans=ans^i;
        return ans;
    }
}
