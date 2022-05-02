class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i=0, j=0;
        int n = nums.length;
        if(n==1)
            return nums;
        while(j<n)
        {
            if((nums[j]&1)==0)
            {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            j++;
        }
        return nums;
    }
}