class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int lo = 0, hi = n-1;
        
        //Not Rotated at all
        if(nums[lo]<=nums[hi])
            return nums[lo];
        
        while(lo<=hi)
        {
            int mid = (lo+hi)/2;
            if(nums[mid] > nums[mid+1])
                return nums[mid+1];
            else if(nums[mid]<nums[mid-1])
                return nums[mid];
            else if(nums[lo]<=nums[mid])
                lo = mid+1;
            else if(nums[mid]<=nums[hi])
                hi = mid-1;
        }
        return nums[0];
    }
}
