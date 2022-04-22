class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        //Base Case
        int contains = 0;
        for(int i=0; i<n; i++) {
            if(nums[i] == 1) {
                contains++;
                break;
            }
        }
        if(contains == 0) {
            return 1;
        }
        
        //Replacing all negatives, zeroes
        //And >n by 1
        for(int i=0; i<n; i++) {
            if((nums[i] <= 0) || (nums[i]>n)) {
                nums[i] = 1;
            }
        }
        for(int i=0; i<n; i++) {
            int a = Math.abs(nums[i]);
            if(a == n) {
                nums[0] = - Math.abs(nums[0]);
            } else {
                nums[a] = - Math.abs(nums[a]);
            }
        }
        
        for(int i=1; i<n; i++) {
            if(nums[i] > 0) 
                return i;
        }
            
        if(nums[0] > 0) {
            return n;
        }
        return n+1;
    }
}