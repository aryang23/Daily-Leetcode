class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        
        int i = 0, j = nums.length - 1, k = nums.length - 1;
        while(i <= j) {
            int si = nums[i]*nums[i];
            int sj = nums[j]*nums[j];
            if(si < sj) {
                ans[k] = sj;
                k--;
                j--;
            } else {
                ans[k] = si;
                k--;
                i++;
            }
        }
        return ans;
    }
}