class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        int[] left = new int[n], right = new int[n];
        left[0] = nums[0];
        right[n-1] = nums[n-1];
        
        for(int i=1;i<n;i++)
        {
            left[i] = left[i-1]*nums[i];
        }
        
        for(int i=n-2;i>=0;i--)
        {
            right[i] = right[i+1]*nums[i];
        }
        
        int[] ans = new int[n];
        ans[0] = right[1];
        ans[n-1] = left[n-2];
        for(int i=1;i<n-1;i++)
        {
            int prod = 1;
            prod = left[i-1]*right[i+1];
            
            ans[i] = prod;
        }
        return ans;
    }
}
