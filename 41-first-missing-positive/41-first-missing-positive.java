class Solution {
    public int firstMissingPositive(int[] nums) {
        //Put MAX in place of -ve
        for(int i=0; i<nums.length; i++) {
            if(nums[i] <= 0) {
                nums[i] = Integer.MAX_VALUE;
            }
        }
        
        //Marking
        for(int i=0; i<nums.length; i++) {
            int val = Math.abs(nums[i]);
            
            if(val-1 >= 0 && val-1 < nums.length && nums[val-1] > 0) {
                nums[val-1] = -nums[val-1];
            }
        }
        
        //Final Ans -> First Unmarked spot
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                return i+1;
            }
        }
        return nums.length + 1;
    }
}