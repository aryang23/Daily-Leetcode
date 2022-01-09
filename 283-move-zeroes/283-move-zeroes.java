class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if(n==1)
            return;
        
        int i=0, j=0;
        while(j<n)
        {
            if(nums[j] != 0)
            {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                
                i++;
            }
            j++;
        }
    }
}