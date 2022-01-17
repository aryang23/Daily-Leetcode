class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permuteHelper(res, ans, nums, 0,visited);
        return res;
        
    }
    
    public void permuteHelper(List<List<Integer>> res, List<Integer> ans, int[] nums, int idx, boolean[] visited)
    {
        
        if(idx==nums.length)
        {
            res.add(new ArrayList<>(ans));
            return;
        }
        
        for(int i=0;i<nums.length;i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                ans.add(nums[i]);
                permuteHelper(res, ans, nums,idx+1, visited);
                ans.remove(ans.size()-1);
                visited[i] = false;
            }
        }
    }
}