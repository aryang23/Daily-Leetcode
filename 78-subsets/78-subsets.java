class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> sa = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        subsets(nums, res, sa, 0);
        return res;
    }
    public void subsets(int[] nums, List<List<Integer>> res, List<Integer> sa, int idx) {
        if(idx==nums.length)
        {
            res.add(new ArrayList<>(sa));
            return;
        }
        subsets(nums, res, sa, idx+1);
        
        sa.add(nums[idx]);
        subsets(nums, res, sa, idx+1);
        sa.remove(sa.size()-1);
    }
}