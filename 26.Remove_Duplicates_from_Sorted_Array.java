class Solution {
    public int removeDuplicates(int[] nums) {
//         int i=1, j=1, k=1, n = nums.length;
//         while(j<n)
//         {
//             while(nums[j-1]==nums[j])
//                 j++;
            
//             if(nums[j-1]!=nums[j])
//             {
//                 // System.out.println(k);
//                 k++;
//                 // i++;
//                 // System.out.println(nums[i]+",,"+nums[j]);
//                 int temp = nums[i];
//                 nums[i] = nums[j];
//                 nums[j] = temp;
//                 // System.out.println(nums[i]+",,"+nums[j]);
//             }
//             j++;
//         }
//         return k;
        
        int i,j, n=nums.length;
        if(n==0)
            return 0;
        i=0;
        for(j=1;j<n;j++)
        {
            if(nums[i]!=nums[j])
            {
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
}
