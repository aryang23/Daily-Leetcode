class Solution {
    public int[] sortArrayByParityII2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int i=0, j=1;
        for(int k=0;k<n;k++)
        {
            if((nums[k]&1)!=0)
            {
                res[j] = nums[k];
                j+=2;
            }
            else
            {
                res[i] = nums[k];
                i+=2;
            }
        }
        return res;
    }
    
    public int[] sortArrayByParityII(int[] nums)
    {
        int i=0, j=1, n=nums.length;
        while(i<n && j<n)
        {
            while(i<n && (nums[i]&1)==0)
            {
                i+=2;
            }
            
            while(j<n && (nums[j]&1)!=0)
            {
                j+=2;
            }
            if(i<n && j<n)
            {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }
}
