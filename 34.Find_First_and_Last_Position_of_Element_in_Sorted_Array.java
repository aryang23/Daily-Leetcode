class Solution {
    //O(n)
    public int[] searchRange2(int[] nums, int target) {
        
        int n = nums.length;
        int fi = -1;
        
        int li = -1;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==target && fi==-1)
            {
                fi = i;
                li = i;
            }
            else if(fi!=-1 && nums[i] == target)
            {
                li = i;
            }
        }
        return new int[]{fi, li};
    }
    
    //O(logN)
    public int[] searchRange(int[] nums, int target)
    {
        int[] ans = {-1, -1};
        
        int lo = 0, hi = nums.length-1;
        
        //First Index
        while(lo<=hi)
        {
            int mid = (lo+hi)/2;
            if(nums[mid]==target)
            {
                ans[0] = mid;
                //Continue searching in left part
                hi = mid-1;
            }
            else if(nums[mid]>target)
                hi = mid-1;
            else
                lo = mid+1;
        }
        
        //Last Index
        lo = 0;
        hi = nums.length-1;
        
        while(lo<=hi)
        {
            int mid = (lo+hi)/2;
            if(nums[mid]==target)
            {
                ans[1] = mid;
                //Continue searching in left part
                lo = mid+1;
            }
            else if(nums[mid]>target)
                hi = mid-1;
            else
                lo = mid+1;
        }
        
        return ans;
    }
}
