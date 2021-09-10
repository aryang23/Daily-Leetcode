class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k==0 || n==1)
            return;
        if(k>n)
            k=k%n;
        
        
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    public void reverse(int[] nums, int st, int end)
    {
        while(st<=end)
        {
            int temp = nums[st];
            nums[st] = nums[end];
            nums[end] = temp;
            st++;
            end--;
        }
    }
}
