class Solution {
    public int missingNumber2(int[] nums) {
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
    
    public int missingNumber(int[] nums)
    {
        int ans = 0, n = nums.length;
        for(int el:nums)
            ans+=el;
        
        return ((n*(n+1))/2)-ans;
    }
}