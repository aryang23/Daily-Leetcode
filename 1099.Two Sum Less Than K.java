class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int answer = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left < right)
        {
            int sum = nums[left] + nums[right];
            if(sum < k)
            {
                answer = Math.max(answer, sum);
                left++;
            }
            else
                right--;
        }
        return answer;
    }
}
