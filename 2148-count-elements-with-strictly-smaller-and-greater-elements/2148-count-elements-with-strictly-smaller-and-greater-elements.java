class Solution {
    public int countElements(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int cnt = 0;
        for(int i=1; i<n-1; i++) {
            if(nums[i] != nums[0] && nums[i] != nums[n-1])
                cnt++;
        }
        return cnt;
    }
}