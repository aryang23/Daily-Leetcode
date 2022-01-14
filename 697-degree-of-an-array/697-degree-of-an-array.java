class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxx = 0;
        for(int num:nums)
        {
            // int val = map.get(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
            int val = map.get(num);
            maxx = Math.max(maxx, val);
        }
        int ans = Integer.MAX_VALUE;
        System.out.println(maxx);
        for(int num : nums)
        {
            if(map.get(num) == maxx)
                ans = Math.min(ans, getLastIdx(nums, num) - getFirstIdx(nums, num) + 1);
        }
        return ans;
    }
    public int getFirstIdx(int[] nums, int tar)
    {
        for(int i=0;i<nums.length;i++)
        {
            int num = nums[i];
            if(num == tar)
                return i;
        }
        return -1;
    }
    public int getLastIdx(int[] nums, int tar){
        for(int i=nums.length-1;i>=0;i--){
            int num = nums[i];
            if(num == tar)
                return i;
        }
        return -1;
    }
}