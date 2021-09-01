class Solution {
    public List<Integer> findDuplicates2(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        if(nums==null || nums.length==0)
            return ans;
        for(int i=0;i<=nums.length-2;i++)
        {
            if(nums[i]==nums[i+1])
                ans.add(nums[i]);
        }
        return ans;
    }
    
    public List<Integer> findDuplicates(int[] nums){
        List<Integer> res = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++)
        {
            int idx = Math.abs(nums[i])-1;
            int val = nums[idx];
            if(val<0)
                res.add(idx+1);
            else
                nums[idx]*=-1;
        }
        return res;
    }
}
