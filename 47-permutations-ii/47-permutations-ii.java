class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();
        int n = nums.length;
        boolean[] visited = new boolean[n];
        permuteUniqueHelper(nums, n, res, smallAns, visited);
        
        return res;
        
    }
    public int prev = -1;
    public void permuteUniqueHelper(int[] nums, int k, List<List<Integer>> res, List<Integer> smallAns, boolean[] visited)
    {
        if(k==0)
        {
            List<Integer> ba = new ArrayList<>(smallAns);
            res.add(ba);
            return;
        }
        
        for(int i=0;i<nums.length;i++)
        {
            if(i>0 && nums[i-1]==nums[i]  && !visited[i-1])
            {
                continue;
            }
            if(!visited[i])
            {
                visited[i] = true;
                smallAns.add(nums[i]);
                permuteUniqueHelper(nums, k-1, res, smallAns, visited);
                smallAns.remove(smallAns.size()-1);
                visited[i] = false;
            }
        }
    }
}