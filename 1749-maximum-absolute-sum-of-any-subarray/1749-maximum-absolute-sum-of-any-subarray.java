class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int curr = 0;
        int max = prev;
        for(int i=1;i<n;i++) {
            curr = Math.max(nums[i], prev + nums[i]);
            max = Math.max(max, curr);
            prev = curr;
        }
        
        
        prev = nums[0];
        curr = 0;
        int min = prev;
        for(int i=1;i<n;i++) {
            curr = Math.min(nums[i], prev + nums[i]);
            min = Math.min(min, curr);
            prev = curr;
        }
        
        return Math.max(Math.abs(max), Math.abs(min));
    }
}