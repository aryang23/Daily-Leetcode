class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        for(int i=0;i<len;i++)
        {
            int m = Math.abs(nums[i]) - 1;
            nums[m] = nums[m]>0?-nums[m]:nums[m];
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<len;i++)
        {
            if(nums[i] > 0)
                res.add(i+1);
        }
        return res;
    }
}
