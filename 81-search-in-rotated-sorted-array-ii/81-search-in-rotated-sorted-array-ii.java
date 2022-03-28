class Solution {
    public boolean search(int[] nums, int target) {

        Arrays.sort(nums);
        return containsTarget(nums, 0, nums.length - 1, target);  
    }
    
    public boolean containsTarget(int [] nums, int start, int end, int target){
        
        if (end < start) return false;
        
        else {
            int mid = (start + end) / 2 ;
            if (nums[mid] == target) return true;

            else if (nums[mid] > target) return containsTarget(nums,start, mid-1, target);

            else return containsTarget(nums,mid + 1, end, target);   
        }   
    }
}
