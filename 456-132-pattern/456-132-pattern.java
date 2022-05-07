class Solution {
    public boolean find132pattern(int[] nums) {
        int min_of_range = Integer.MAX_VALUE; 
        int max_of_range = Integer.MIN_VALUE;
        int left = nums[0]; // left of three elements
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] >= min_of_range && nums[i] <= max_of_range) 
                return true;
            
            int middle = nums[i];
            
            // we need to find right in range [left+1, right-1] (inclusive) 
            if(left + 1 <= middle - 1) { // atleast one element is there to be right 
                if(left+1 < min_of_range) min_of_range = left+1;
                if(middle-1 > max_of_range) max_of_range = middle-1;   
            }
            
            left = Math.min(left, nums[i]);
        }
        return false;
    }
}
