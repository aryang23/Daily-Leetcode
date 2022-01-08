class Solution {
    public int[] sortedSquares2(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            nums[i]*=nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
    
    public int[] sortedSquares(int[] nums)
    {
        int n = nums.length;
        int start = 0, end = n-1, i = n-1;
        int[] result = new int[n];
        
        while(start<=end)
        {
            int a = nums[start]*nums[start], b = nums[end]*nums[end];
            if(a>b)
            {
                result[i] = a;
                start++;
            }
            else
            {
                result[i] = b;
                end--;
            }
            i--;
        }
        return result;
    }
}