class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i = 0, j = 0, k = n-1;
        while(j<=k) {
            int ele = nums[j];
            if(ele == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                
                i++;
                j++;
            } else if(ele == 1) {
                j++;
            } else {
                int temp = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;
                
                k--;
            }
        }
    }
}