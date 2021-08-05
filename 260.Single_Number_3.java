class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        int n= nums.length;
        for(int i=0;i<n;i++)
        {
            xor^=nums[i];
        }
        int xor_mask = (xor)&(-xor);
        
        int A = 0, B = 0;
        for(int el:nums)
        {
            if((el&xor_mask) == 0)
                A^=el;
            else
                B^=el;
        }
        
        return new int[]{A,B};
        
    }
}
