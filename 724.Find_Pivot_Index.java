class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        left[0]=nums[0];
        int[] right = new int[n];
        for(int i=1;i<n;i++)
        {
            left[i] = left[i-1] + nums[i];
        }
        right[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--)
        {
            right[i] = right[i+1] + nums[i];
        }
        
        int ans = -1;
        for(int i=0;i<n;i++)
        {
            if(left[i]==right[i])
            {
                ans=i;
                break;
            }
        }
        return ans;
        
    }
}
