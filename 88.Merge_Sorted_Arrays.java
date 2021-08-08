class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if(n==0)
            return;
        
        if(m==0)
        {
            for(int i=0;i<n;i++)
            {
                nums1[i] = nums2[i];
            }
            return;
        }
        
        int[] nums3 = new int[nums1.length];
        int i = 0, j = 0, k = 0;
        
        while(i<m && j<n)
        {
            if(nums1[i]<nums2[j])
            {
                nums3[k++] = nums1[i++];
            }
            else
            {
                nums3[k++] = nums2[j++];
            }
        }
        
        while(i<m)
        {
            nums3[k++] = nums1[i++];
        }
        
        while(j<n)
        {
            nums3[k++] = nums2[j++];
        }
        
        for(i=0;i<nums1.length;i++)
        {
            nums1[i] = nums3[i];
        }
        
    }
}
