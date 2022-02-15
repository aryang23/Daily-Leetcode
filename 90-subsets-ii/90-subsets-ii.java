class Solution {
    List<List<Integer>> output;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        output = new ArrayList();
        List<Integer> smallAns = new ArrayList<>();
        // List<List<Integer>> res = new ArrayList<>();
        // subsetsWithDupHelper(nums, smallAns, res, 0);
        subsetsWithDupHelper2(nums, smallAns, 0);
        return output;
        
    }
    
    public void subsetsWithDupHelper(int[] nums, List<Integer> smallAns, List<List<Integer>> res, int idx)
    {
        if(idx==0)
        {
            List<Integer> ba = new ArrayList<>(smallAns);
            res.add(ba);
            return;
        }
        
        //2 Calls
        subsetsWithDupHelper(nums, smallAns, res, idx+1);
        
        //Inclusive
        smallAns.add(nums[idx]);
        subsetsWithDupHelper(nums, smallAns, res, idx+1);
        // smallAns.remove(smallAns.size()-1);
    }
    
    public void subsetsWithDupHelper2(int[] nums, List<Integer> smallAns, int index)
    {
        output.add(new ArrayList(smallAns));
        
        for(int i=index;i<nums.length;i++)
        {
            if(i!=index && i>0 && nums[i] == nums[i-1])
                continue;
            
            smallAns.add(nums[i]);
            subsetsWithDupHelper2(nums, smallAns, i + 1);
            smallAns.remove(smallAns.size()-1);
        }
    }
}