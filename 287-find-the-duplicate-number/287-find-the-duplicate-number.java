class Solution {
    
    public int findDuplicate(int[] nums){
        int dup = -1;
        for(int i=0; i<nums.length; i++) {
            int cur = Math.abs(nums[i]);
            if(nums[cur] < 0) {
                dup = cur;
                break;
            } else {
                nums[cur] *= -1;
            }
        }
        for(int i=0; i<nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        return dup;
    }
}