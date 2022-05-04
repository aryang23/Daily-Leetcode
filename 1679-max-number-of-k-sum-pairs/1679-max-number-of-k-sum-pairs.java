class Solution {
    public int maxOperations(int[] nums, int k) {
        int n = nums.length;
        
        Arrays.sort(nums);
        
        int left = 0, right = n-1;
        int cnt = 0;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum == k) {
                cnt++;
                // System.out.println(left+",,"+right);
                left++;
                right--;
            } else if(sum > k) {
                right--;
            } else {
                left ++;
            }
        }
        return cnt;
    }
}
