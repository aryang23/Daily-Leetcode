class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++)
        {
            arr[i][0] = nums[i];
            arr[i][1] = i+1;
        }
        
        int left = 0, right = n-1;
        while(left<right)
        {
            int sum = arr[left][0] + arr[right][0];
            if(sum==target)
            {
                return new int[]{arr[left][1], arr[right][1]};
            }
            else if(sum > target)
                right--;
            else
                left++;
        }
        return new int[]{};
    }
}
